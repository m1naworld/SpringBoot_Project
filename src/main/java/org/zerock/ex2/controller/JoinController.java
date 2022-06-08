package org.zerock.ex2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ex2.DTO.JoinForm;
import org.zerock.ex2.Service.JoinService;



@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class JoinController {

    private JoinService joinService;


    @PostMapping("/join")
    public JoinForm createUser(@RequestBody JoinForm form){
        System.out.println(form);
        Long newUser = joinService.createUser(form);
        System.out.println("newUser:" + newUser);
        return form;
    }


}
