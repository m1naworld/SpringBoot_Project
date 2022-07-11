package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//구현체 없이 인터페이스를 통해서만 주입!
//Sping Data JPA가 JpaRepository를 보고 구현체를 자동으로 만들어 스프링 Bean에 자동으로 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    @Override
    Optional<Member> findByName(String name);

}
