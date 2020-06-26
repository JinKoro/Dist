package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.model.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class LiteratureService implements Service<Literature> {
    private DaoRepos<Literature> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Literature> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Literature literature) {
        this.daoRepos.create(literature);
    }

    @Override
    @Transactional
    public void update(Literature literature) {
        this.daoRepos.update(literature);
    }

    @Override
    @Transactional
    public void delete(Literature literature) {
        this.daoRepos.delete(literature);
    }

    @Override
    @Transactional
    public void save(Literature literature) {
        this.daoRepos.save(literature);
    }

    @Override
    @Transactional
    public List<Literature> findAll(Class T) {
        return this.daoRepos.findAll(T);
    }
}
