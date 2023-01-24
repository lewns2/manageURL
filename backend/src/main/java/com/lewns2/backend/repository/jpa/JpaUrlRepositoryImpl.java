package com.lewns2.backend.repository.jpa;

import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.UrlRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class JpaUrlRepositoryImpl implements UrlRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void save(Url url) {
        this.em.persist(url);
    }
}
