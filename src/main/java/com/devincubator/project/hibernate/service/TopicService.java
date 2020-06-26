package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Topic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@org.springframework.stereotype.Service
public class TopicService implements Service<Topic> {

    private DaoRepos<Topic> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Topic> daoRepos) {
        this.daoRepos = daoRepos;
    }


    @Override
    @Transactional
    public void add(Topic topic) {
        daoRepos.create(topic);
    }

    @Override
    @Transactional
    public void update(Topic topic) {
        daoRepos.update(topic);
    }

    @Override
    @Transactional
    public void delete(Topic topic) {
        daoRepos.delete(topic);
    }

    @Override
    @Transactional
    public void save(Topic topic) {
        daoRepos.save(topic);
    }

    @Override
    @Transactional
    public List<Topic> findAll(Class T) {
        return daoRepos.findAll(T);
    }

}
