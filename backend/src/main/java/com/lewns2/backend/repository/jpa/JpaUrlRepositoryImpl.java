package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.UrlRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;


@Repository
public class JpaUrlRepositoryImpl implements UrlRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(Url url) {
        this.em.persist(url);
    }

    @Override
    public List<Url> findUrls(Board board) {
        Long boardId = board.getId();
        Query query = this.em.createQuery("SELECT u FROM Url u WHERE u.board.id= :id");
        query.setParameter("id", boardId);
        return query.getResultList();
    }

    @Override
    public void delete(Url url) {
        String urlId = url.getId().toString();
        this.em.createQuery("DELETE FROM Url url WHERE id= " + urlId).executeUpdate();
    }
}
