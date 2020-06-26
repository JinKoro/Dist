package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Question;
import com.devincubator.project.hibernate.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class QuestionService implements Service<Question>{
    private DaoRepos<Question> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Question> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Question question) {
        this.daoRepos.create(question);
    }

    @Override
    @Transactional
    public void update(Question question) {
        this.daoRepos.update(question);
    }

    @Override
    @Transactional
    public void delete(Question question) {
        this.daoRepos.delete(question);
    }

    @Override
    @Transactional
    public void save(Question question) {
        this.daoRepos.save(question);
    }

    @Override
    @Transactional
    public List<Question> findAll(Class T) {
        return this.daoRepos.findAll(T);
    }
}
