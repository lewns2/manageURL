package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaMemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
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
