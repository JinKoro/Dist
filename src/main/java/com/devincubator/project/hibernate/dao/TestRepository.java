package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepository implements DaoRepos<Test> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Test test) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(test);
    }

    @Override
    public void update(Test test) {
        Session session = sessionFactory.getCurrentSession();
        session.update(test);
    }

    @Override
    public void delete(Test test) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(test.getTestId()));
        if(test!=null){
            session.delete(test);
        }
    }

    @Override
    public void save(Test test) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(test);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Test> findAll(Class T) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Test").list();
    }
}



