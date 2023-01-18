package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.repository.BoardRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaBoardRepositoryImpl implements BoardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Board board) {
        this.em.persist(board);
    }
}
