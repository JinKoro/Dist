package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class AnswerService implements Service<Answer> {
    private DaoRepos<Answer> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Answer> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Answer answer) {
        this.daoRepos.create(answer);
    }

    @Override
    @Transactional
    public void update(Answer answer) {
        this.daoRepos.update(answer);
    }

    @Override
    @Transactional
    public void delete(Answer answer) {
        this.daoRepos.delete(answer);
    }

    @Override
    @Transactional
    public void save(Answer answer) {
        this.daoRepos.save(answer);
    }

    @Override
    @Transactional
    public List<Answer> findAll() {
        return this.daoRepos.findAll();
    }
}
