package com.example.hello.controller;


import com.example.hello.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    // GET API에서는 URL의 경로나 파라미터에 변수를 넣어 요청을 보냈지만 POST API에서는 저장하고자 하는 리소스나 값을 HTTP 바디에 담아 서버에 전달

    // @RequestMapping 사용법
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){  // @RequestBody는 HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
        // Map객체는 요청을 통해 어떤 값이 들어오게 될지 특정하기 어려울 때 주로 사용. 요청 메시지에 들어갈 값이 정해져 있다면 DTO 객체를 매개변수로 삼아 작성할 수 있음
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }


    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
