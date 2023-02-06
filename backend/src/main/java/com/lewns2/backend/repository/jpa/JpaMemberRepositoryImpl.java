package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.repository.MemberRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Override
    public Member findMemberByNickName(String nickname) {
        String qlString = "select m from Member m where m.nickname= :nickname";

        Member findMember = this.em.createQuery(qlString, Member.class).setParameter("nickname", nickname).getSingleResult();
//        Query query = this.em.createQuery("select m from member m where m.nickname" + nickName);
//        Member findMember = query.getSingleResult();

        return findMember;
    }
}
