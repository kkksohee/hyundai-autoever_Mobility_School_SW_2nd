package com.hd.sample_jpa_mysql_0605.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class ChatRoomResDto { //채팅방 개설에 대한 응답
    private String roomId;
    private String name;
    private LocalDateTime regDate; //채팅방 생성 시간
    //-> 방 개설

    @JsonIgnore // 이 정보는 내려가지 말라는 뜻, 직렬화해서 내려갈때 -> 내부에서 관리하기 위한 정보 -> 오ㅐ??
    private Set<WebSocketSession> sessions;

    public boolean isSessionEmpty() {
        return this.sessions.size() == 0;
    }

    @Builder // 빌더 패턴 적용
    public ChatRoomResDto(String roomId, String name, LocalDateTime regDate) {
        this.roomId = roomId;
        this.name = name;
        this.regDate = regDate;
        this.sessions = Collections.newSetFromMap(new ConcurrentHashMap<>()); // 동시성 문제를 해결하기 위해 ConcurrentHashMap 사용
    }

}
