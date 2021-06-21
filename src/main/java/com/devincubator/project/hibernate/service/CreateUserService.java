package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.dao.DaoRepos;
import com.devincubator.project.hibernate.dao.RoleRepository;
import com.devincubator.project.hibernate.dao.UserRepository;
import com.devincubator.project.hibernate.model.Role;
import com.devincubator.project.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateUserService implements CreateUserServiceInterface{

    private DaoRepos<User> daoRepos;


    public void setDaoRepos(DaoRepos<User> daoRepos) {
        this.daoRepos = daoRepos;
    }

    @Override
    @Transactional
    public void createUser(User user, String nameRole){
        user.setNameRole(nameRole);
        daoRepos.create(user);
    }


    @Transactional
    public List<String> getAllRoles(){
        List<String> namesRole = new ArrayList<>();
        for (Role r: new RoleRepository().findAll()
             ) {
            namesRole.add(r.getNameRole());
        };
        return namesRole;
    }

}
