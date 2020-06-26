package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepository implements DaoRepos<Answer> {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Answer answer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(answer);
    }

    @Override
    public void update(Answer answer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(answer);
    }

    @Override
    public void delete(Answer answer) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(answer.getAnswerId()));
        if(answer!=null){
            session.delete(answer);
        }
    }

    @Override
    public void save(Answer answer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(answer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Answer> findAll(Class Answer) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Answer").list();
    }
}
