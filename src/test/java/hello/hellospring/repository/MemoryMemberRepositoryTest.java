package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 자바 코드를 통한 테스트 = 단위테스트: 빠름. 통합테스트보다 단위테스트를 잘만드는게 좋음..?!
public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach // 각 메서드가 끝나면 실행되는 콜백 메서드
//    public void afterEach(){
//        repository.clearStore();
//    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //get() -> Optional<> 관련 메소드
        Member result = repository.findById(member.getId()).get();
        // 같은지 틀린지 확인하는 방법
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
//        Assertions.assertEquals(member, null);
        // 요즘 쓰는 방법
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}


