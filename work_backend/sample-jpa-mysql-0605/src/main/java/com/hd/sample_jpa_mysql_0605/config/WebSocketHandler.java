package com.hd.sample_jpa_mysql_0605.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hd.sample_jpa_mysql_0605.dto.ChatMessageDto;
import com.hd.sample_jpa_mysql_0605.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@RequiredArgsConstructor
//핸들러로 들어오니까 역직렬화 할 맵퍼가 필요하고, 컨트롤러에서 의존성 주입 받는 것
//메세지가 올라오면
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper; //메세지의 역직렬화(JSON으로 들어오면 까서 객체로 저장하기 위해)
    private final ChatService chatService;

    // 세션별 채팅방 ID 저장 -> 사용자별로 ID가 필요하다는 말인가?
    //일반적인 HashMap을 사용하면 안됨 -> 이유는..?
    private final Map<WebSocketSession, String> sessionRoomIdMap = new ConcurrentHashMap<>();
    //메세지와 연결에 대한 세션(사용자에 대한 연결) 정보
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload(); // 클라이언트가 전송한 메시지
        log.warn("{}", payload);
        // 1) 수신된 JSON을 DTO로 역직렬화 (클라이언트에서 올라온 데이터(JSON) DTO로 바꿈 Mapper를 통해, 여기서 고유한 룸아이디 빼야 함)
        ChatMessageDto chatMessage = objectMapper.readValue(payload, ChatMessageDto.class);
        String roomId = chatMessage.getRoomId(); // 채팅방 ID
        // 세션과 채팅방 ID를 매핑
        sessionRoomIdMap.put(session, chatMessage.getRoomId());  // 세션과 채팅방 ID를 매핑
        if (chatMessage.getType() == ChatMessageDto.MessageType.ENTER) { // 메시지 타입이 ENTER이면
            chatService.addSessionAndHandleEnter(roomId, session, chatMessage); // 채팅방에 입장한 세션 추가
        } else if (chatMessage.getType() == ChatMessageDto.MessageType.CLOSE) {
            chatService.removeSessionAndHandleExit(roomId, session, chatMessage);
        } else {
            chatService.sendMessageToAll(roomId, chatMessage);
        }
    }
    //연결 해제 이후, 닫히고 난 후에 불려짐,프론트엔드가 close를 보내준 후
    //프론트 엔드가 그냥 폰을 꺼버려->불완전 종료 -> 따로 처리해야함 (웹은 사실 안해도됨 잘 안일어남)
    //모바일은 많이 일어남! 불완전종료 처리를 위해 별도의 루틴 만들어야함
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 세션과 매핑된 채팅방 ID 가져오기
        log.warn("afterConnectionClosed : {}", session);
        String roomId = sessionRoomIdMap.remove(session);
        if (roomId != null) {
            ChatMessageDto chatMessage = new ChatMessageDto();
            chatMessage.setType(ChatMessageDto.MessageType.CLOSE);
            chatService.removeSessionAndHandleExit(roomId, session, chatMessage);
        }
    }


}
