package com.example.hello.controller;

import com.example.hello.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

@RestController  // @ResponseBody 생략 가능 -> @ResponseBody 어노테이션은 자동으로 값을 JSON과 같은 형식으로 변환해서 전달하는 역할 수행
@RequestMapping("/api/v1/put-api")
public class PutController {

    // 서버에 어떤 값이 들어올지 모르는 경우 Map 객체 활용
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {sb.append(map.getKey() + " : " + map.getValue() + "\n");});

        return sb.toString();
    }

    // 서버에 들어오는 요청에 담겨 있는 값이 정해져 있는 경우 -> DTO 객체 활용
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();  // 전달받은 값 형태 'text/plain'
    }

    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto; // 전달받은 값 형태 'application/json'
    }


    // ResponseEntity 활용
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto); // HttpStatus.ACCEPTED 응답코드 202를 가지고 있음 
    }
}
