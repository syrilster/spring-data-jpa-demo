package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Syril on 18-05-2018.
 */
// marker for any class that fulfills the role or stereotype (also known as Data Access Object or DAO) of a repository.
@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
