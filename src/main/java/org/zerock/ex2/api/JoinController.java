package org.zerock.ex2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.ex2.entity.Member;
import org.zerock.ex2.repository.MemberRepository;

import java.util.Optional;

@RestController
@RequestMapping("api/join")
public class JoinController {

    MemberRepository memberRepository;

    @PostMapping({"","/"})
    public String join(@RequestBody Member member){
//
//        Optional<Member> result=memberRepository.findOne(member.id);
//        if(member1 != null){
//
//        }
//        member.ID
        return "가입 성공";
    }


}
