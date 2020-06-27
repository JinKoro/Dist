package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.dao.RoleRepository;
import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.model.Topic;
import com.devincubator.project.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService implements Service<User>{

    private DaoRepos<User> daoRepos;

    private RoleRepository roleRepository;

    @Autowired
    public void setDaoRepos(DaoRepos<User> daoRepos) {
        this.daoRepos = daoRepos;
    }


    @Transactional
    public void add(User user) {
        daoRepos.create(user);
    }


    @Transactional
    public void update(User user) {
        daoRepos.update(user);
    }


    @Transactional
    public void delete(User user) {
        daoRepos.delete(user);
    }


    @Transactional
    public void save(User user) {
        daoRepos.save(user);
    }


    @Transactional
    public List<User> findAll() {
        return daoRepos.findAll();
    }

    @Transactional
    public List<String> getAllRoles(){
        List<String> namesRole = new ArrayList<>();
        for (Role r: roleRepository.findAll()
        ) {
            namesRole.add(r.getNameRole());
        };
        return namesRole;
    }
}
