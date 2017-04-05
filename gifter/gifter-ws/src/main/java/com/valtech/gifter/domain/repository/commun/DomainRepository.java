package com.valtech.gifter.domain.repository.commun;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public abstract class DomainRepository {
    @Autowired
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Session getCurrentHbnSession() {
        return getEntityManager().unwrap(Session.class);
    }
}
