package com.hd.sample_jpa_mysql_0605.dto;

import lombok.*;

@Getter@Setter @NoArgsConstructor //생성자 대체 방법
public class ChatMessageDto {
    public enum MessageType { ENTER, TALK, CLOSE } //프론트엔드가 올려주는 부분
    private MessageType type; //?
    private String roomId;
    private String sender; //메세지를 보내는 주체
    private String message;
}
