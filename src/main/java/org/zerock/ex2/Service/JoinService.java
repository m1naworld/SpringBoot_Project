package org.zerock.ex2.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.DTO.JoinForm;
import org.zerock.ex2.entity.Member;
import org.zerock.ex2.repository.MemberRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JoinService {
    private MemberRepository memberRepository;

    @Transactional
    public Long createUser(JoinForm form){
        Member member = form.toEntity();
        memberRepository.save(member);
        System.out.println("success");
        return member.getNum();
    }

}
