package com.reservation.repository;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.reservation.dto.MemberSearchCond;
import com.reservation.entity.Member;
import com.reservation.entity.QMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.reservation.entity.QMember.member;

@Repository
@Transactional
public class MemberRepositoryImpl {

    private final JPAQueryFactory query;

    public MemberRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Member> findAll(MemberSearchCond cond) {
        return query.select(member)
                .from(member)
                .where(
                        likeMemberId(cond.getId()),
                        likeNickname(cond.getName()),
                        likeMemberPassword(cond.getPassword())
                )
                .fetch();
    }

    public Boolean findMemberForDuplicate(String memberId) {
        Member members = query.select(member)
                .from(member)
                .where(
                        equalMemberId(memberId)
                )
                .fetchOne();
        if (members == null) {
            return true;
        } else {
            return false;
        }
    }

    public Member findMemberForLogin(String memberId, String password) {
        Member member1 = query.select(member)
                .from(member)
                .where(
                        equalMemberId(memberId),
                        equalMemberPassword(password))
                .fetchOne();

        return member1;
    }

    public Member findMemberWithMemberId(String memberId) {
        Member member1 = query.select(member)
                .from(member)
                .where(
                        equalMemberId(memberId)
                ).fetchOne();
        return member1;
    }

    public BooleanExpression equalMemberId(String memberId) {
        if (StringUtils.hasText(memberId)) {
            return member.id.eq(memberId);
        }
        return null;
    }

    public BooleanExpression equalMemberPassword(String memberPassword) {
        if (StringUtils.hasText(memberPassword)) {
            return member.password.eq(memberPassword);
        }
        return null;
    }




    public BooleanExpression likeMemberId(String memberId) {
        if (StringUtils.hasText(memberId)) {
            return member.id.like("%" + memberId + "%");
        }
        return null;
    }

    public BooleanExpression likeMemberPassword(String memberPassword) {
        if (StringUtils.hasText(memberPassword)) {
            return member.password.like("%" + memberPassword + "%");
        }
        return null;
    }

    public BooleanExpression likeNickname(String nickname) {
        if (StringUtils.hasText(nickname)) {
            return member.name.like("%" + nickname + "%");
        }
        return null;
    }


}
