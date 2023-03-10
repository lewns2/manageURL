package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.BoardRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class JpaBoardRepositoryImpl implements BoardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Board board) {
        this.em.persist(board);
    }

    @Override
    public Optional<Board> findById(Long boardId) {

        try {
            return Optional.of(this.em.find(Board.class, boardId));
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    @Override
    public List<Board> findByMemberId(Long memberId) {
        Query query = this.em.createQuery("SELECT b FROM Board b where b.member.id= :id");
        query.setParameter("id", memberId);
        return query.getResultList();
    }

    @Override
    public void delete(Long boardId) {
        this.em.createQuery("DELETE FROM Board board WHERE id=" + boardId).executeUpdate();
    }
}
