package com.hd.sample_jpa_mysql_0605.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ChatRoomReqDto { //방개설 요청(누가 개설했는지, 토큰안에 아이디값이 있으니 그 아이디로 해도 됨)
    //private String email;   //방 개설자
    private String name;    //방 제목
}
