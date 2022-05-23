package org.zerock.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex2.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
}
