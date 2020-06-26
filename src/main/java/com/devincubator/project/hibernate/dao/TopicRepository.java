package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepository implements DaoRepos<Topic> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(topic);
    }

    @Override
    public void update(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(topic);
    }

    @Override
    public void delete(Topic topic) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(topic.getTopicId()));
        if(topic!=null){
            session.delete(topic);
        }
    }

    @Override
    public void save(Topic topic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(topic);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Topic> findAll(Class T) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Topic").list();
    }

}
