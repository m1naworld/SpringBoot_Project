package com.example.hello.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // @PathVariable를 이용하면 URI에 포함된 값을 받아 로직을 처리
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    // 쿼리스트링 사용
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail : " + email;
    }

}
