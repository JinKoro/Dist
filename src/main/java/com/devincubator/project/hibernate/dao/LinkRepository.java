package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Link;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkRepository implements DaoRepos<Link>{


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Link link) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(link);
    }

    @Override
    public void update(Link link) {
        Session session = sessionFactory.getCurrentSession();
        session.update(link);
    }

    @Override
    public void delete(Link link) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(link.getLinkId()));
        if(link!=null){
            session.delete(link);
        }
    }

    @Override
    public void save(Link link) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(link);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Link> findAll(Class Link) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Link").list();
    }
}
