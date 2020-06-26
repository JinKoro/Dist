package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Answer;
import com.devincubator.project.hibernate.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class LinkService implements Service<Link> {
    private DaoRepos<Link> daoRepos;

    @Autowired
    public void setDaoRepos(DaoRepos<Link> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Link link) {
        this.daoRepos.create(link);
    }

    @Override
    @Transactional
    public void update(Link link) {
        this.daoRepos.update(link);
    }

    @Override
    @Transactional
    public void delete(Link link) {
        this.daoRepos.delete(link);
    }

    @Override
    @Transactional
    public void save(Link link) {
        this.daoRepos.save(link);
    }

    @Override
    @Transactional
    public List<Link> findAll(Class T) {
        return this.daoRepos.findAll(T);
    }
}
