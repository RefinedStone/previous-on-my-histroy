package com.sparata.testsubmit.Repository;

import com.sparata.testsubmit.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByOrderByCreatedTimeDesc();
}