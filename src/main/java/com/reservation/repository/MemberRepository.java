package com.reservation.repository;

import com.reservation.entity.Comment;
import com.reservation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Intger> {
}
