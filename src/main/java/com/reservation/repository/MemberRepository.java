package com.reservation.repository;

import com.reservation.entity.Comment;
import com.reservation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findById(String name);
}
