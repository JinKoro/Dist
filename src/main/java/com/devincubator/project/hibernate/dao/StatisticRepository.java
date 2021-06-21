package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Statistic;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticRepository implements DaoRepos<Statistic> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Statistic statistic) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(statistic);
    }

    @Override
    public void update(Statistic statistic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(statistic);
    }

    @Override
    public void delete(Statistic statistic) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(statistic.getStatisticId()));
        if(statistic!=null){
            session.delete(statistic);
        }
    }

    @Override
    public void save(Statistic statistic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(statistic);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Statistic> findAll() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Statistic ").list();
    }
}
