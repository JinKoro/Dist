package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Literature;
import com.devincubator.project.hibernate.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@org.springframework.stereotype.Service
public class StatisticService implements Service<Statistic> {
    private DaoRepos<Statistic> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Statistic> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Statistic statistic) {
        this.daoRepos.create(statistic);
    }

    @Override
    @Transactional
    public void update(Statistic statistic) {
        this.daoRepos.update(statistic);
    }

    @Override
    @Transactional
    public void delete(Statistic statistic) {
        this.daoRepos.delete(statistic);
    }

    @Override
    @Transactional
    public void save(Statistic statistic) {
        this.daoRepos.save(statistic);
    }

    @Override
    @Transactional
    public List<Statistic> findAll() {
        return this.daoRepos.findAll();
    }
}
