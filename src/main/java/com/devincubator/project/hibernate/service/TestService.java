package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class TestService implements Service<Test>{


    private DaoRepos<Test> daoRepos;

    @Autowired  public void setDaoRepos(DaoRepos<Test> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Test test) {
        this.daoRepos.create(test);
    }

    @Override
    @Transactional
    public void update(Test test) {
        this.daoRepos.update(test);
    }

    @Override
    @Transactional
    public void delete(Test test) {
        this.daoRepos.delete(test);
    }

    @Override
    @Transactional
    public void save(Test test) {
        this.daoRepos.save(test);
    }

    @Override
    @Transactional
    public List<Test> findAll(Class T) {
        return this.daoRepos.findAll(T);
    }
}
