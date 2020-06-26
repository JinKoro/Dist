package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Literature;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LiteratureRepository implements DaoRepos<Literature> {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Literature literature) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(literature);
    }

    @Override
    public void update(Literature literature) {
        Session session = sessionFactory.getCurrentSession();
        session.update(literature);
    }

    @Override
    public void delete(Literature literature) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(literature.getLiteratureId()));
        if(literature!=null){
            session.delete(literature);
        }
    }

    @Override
    public void save(Literature literature) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(literature);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Literature> findAll(Class Literature) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Literature ").list();
    }
}
