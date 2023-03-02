package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.rest.exception.notfound.MemberNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

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


        return findMember;
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        String qlString = "select m from Member m where m.email= :email";

        try {
            return Optional.of(this.em.createQuery(qlString, Member.class).setParameter("email", email).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
