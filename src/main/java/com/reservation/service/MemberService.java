package com.reservation.service;

import com.reservation.dto.MemberSearchCond;
import com.reservation.entity.Member;
import com.reservation.repository.MemberRepository;
import com.reservation.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberRepositoryImpl memberRepositoryImpl;

    public Member save(Member member) {
        if (memberRepositoryImpl.findMemberForDuplicate(member.getId()) == true) {
            return memberRepository.save(member);
        } else {
            return null;
        }
    }

    public Optional<Member> findById(int id) {
        return memberRepository.findById(id);
    }

    public Member findByMemberId(String memberId) {
        return memberRepositoryImpl.findMemberWithMemberId(memberId);
    }

    public List<Member> findMembers(MemberSearchCond memberSearchCond) {
        return memberRepositoryImpl.findAll(memberSearchCond);
    }


}
