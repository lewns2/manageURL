package com.lewns2.backend.domain.member;

import javax.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    // 엔티티매니저 생성자
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        Member member = em.find(Member.class, memberId);
        return member;
    }
}
