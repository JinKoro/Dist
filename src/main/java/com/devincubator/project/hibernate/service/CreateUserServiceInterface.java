package com.devincubator.project.hibernate.service;

import com.devincubator.project.hibernate.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreateUserServiceInterface {
    public void createUser(User user, String nameRole);

}
