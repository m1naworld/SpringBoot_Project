package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//test를 실행할 때 트렌잭션을 먼저 실행 하고 db에 데이터를 insert하고 test가 끝나면 rollback을 해줌!
// 이를 통해 DB에 실제로 데이터가 반영되지 않아 반복적으로 테스트를 실행할 수 있음
// 그래서 따로 @AfterEach를 통한 코드를 작성할 필요 없음.
class MemberServiceTest {

    // 생성자 인젝션이 좋은데 test는 그냥 필드 기반으로 하면 편함
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    // 원래는 test용 전용 db 따로 구축.
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail("예외처리 실패");
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        // try-catch 문 말고, 아래 기능도 제공
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then


    }

}