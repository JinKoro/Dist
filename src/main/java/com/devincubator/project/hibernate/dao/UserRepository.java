package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.UserDataHandler;

import java.util.List;

@Repository
public class UserRepository implements DaoRepos<User> {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void delete(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(user.getUserId()));
        if(user!=null){
            session.delete(user);
        }
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll(Class User) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from User").list();
    }

    public List<User> findByUserName(String firstName) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from User where firstName="+firstName).list();
    }
}
