package com.sparata.testsubmit.Service;

import com.sparata.testsubmit.Repository.MemberRepository;
import com.sparata.testsubmit.domain.Member;
import com.sparata.testsubmit.entity.MemberInfoResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Transactional
    public MemberInfoResponseDto findMember(Long memberId) {
//        Member member = new Member();
//        member =memberRepository.findById(memberId).orElse(null);
        MemberInfoResponseDto memberDto = new MemberInfoResponseDto(memberRepository.findById(memberId).orElse(null));
        return memberDto;

    }
    public MemberInfoResponseDto findMembers(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        MemberInfoResponseDto responseDto = new MemberInfoResponseDto();
//        member.update()

        //  return member.orElse(null);

    }
    @Transactional
    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }
}