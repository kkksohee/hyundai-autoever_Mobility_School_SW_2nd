package com.hd.sample_jpa_mysql_0605.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestJsonController {
    @GetMapping("/members")
    public List<Map<String, Object>> findMembers(){ //메서드
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i=0; i<20; i++){
            Map<String,Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i+"번 개발자");
            member.put("age", 10+i);
            members.add(member);
        }
        return members;
    }

}
