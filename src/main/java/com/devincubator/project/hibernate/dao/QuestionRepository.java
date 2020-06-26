package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class QuestionRepository implements DaoRepos<Question> {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(question);
    }

    @Override
    public void update(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.update(question);
    }

    @Override
    public void delete(Question question) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(question.getQuestionId()));
        if(question!=null){
            session.delete(question);
        }
    }

    @Override
    public void save(Question question) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(question);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Question> findAll(Class question) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Question").list();
    }
}
