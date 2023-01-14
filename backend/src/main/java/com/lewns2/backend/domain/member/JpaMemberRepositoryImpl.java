package com.lewns2.backend.domain.member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class JpaMemberRepositoryImpl implements MemberRepository{

//    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {
        this.em.persist(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        Member findMember = this.em.find(Member.class, memberId);
        return findMember;
    }
}
