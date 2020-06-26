package com.devincubator.project.hibernate.dao;

import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.model.Test;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository implements DaoRepos<Role>{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(role);
    }

    @Override
    public void update(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.update(role);
    }

    @Override
    public void delete(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        Topic deleteTopic = session.load(Topic.class,Integer.valueOf(role.getRoleId()));
        if(role!=null){
            session.delete(role);
        }
    }

    @Override
    public void save(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findAll(Class Role) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Role").list();
    }
}
