package com.sparta.jwt_submit_try4.repository;


import com.sparta.jwt_submit_try4.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findBynickname(String nickname);
    boolean existsBynickname(String nickname);
}
