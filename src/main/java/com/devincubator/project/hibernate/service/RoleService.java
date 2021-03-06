package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class RoleService implements Service<Role>{
    private DaoRepos<Role> daoRepos;

    public void setDaoRepos(DaoRepos<Role> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void add(Role role) {
        this.daoRepos.create(role);
    }

    @Override
    @Transactional
    public void update(Role role) {
        this.daoRepos.update(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        this.daoRepos.delete(role);
    }

    @Override
    @Transactional
    public void save(Role role) {
        this.daoRepos.save(role);
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        return this.daoRepos.findAll();
    }


}
