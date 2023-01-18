package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.repository.BoardRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaBoardRepositoryImpl implements BoardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Board board) {
        this.em.persist(board);
    }

    @Override
    public List<Board> findByMemberId(Long memberId) {
        Query query = this.em.createQuery("SELECT b FROM Board b where b.member.id= :id");
        query.setParameter("id", memberId);
        return query.getResultList();
    }
}
