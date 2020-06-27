package com.devincubator.project.hibernate.controller.admin;

import com.devincubator.project.hibernate.model.User;


import com.devincubator.project.hibernate.service.CreateUserService;
import com.devincubator.project.hibernate.service.CreateUserServiceInterface;
import com.devincubator.project.hibernate.service.Service;
import com.devincubator.project.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class HomePageAdminController {
    @Autowired
    private Service<User> service;

    private CreateUserServiceInterface createUserServiceInterface;

    public final String[] arr = {"ROLE_USER","ROLE_ADMIN","ROLE_TUTOR"};
    @Autowired
    public void setCreateUserServiceInterface(CreateUserServiceInterface createUserServiceInterface) {
        this.createUserServiceInterface = createUserServiceInterface;
    }


    public void setService(Service<User> service) {
        this.service = service;
    }

    @PostMapping("/createUser")
    public String createUserGet(Model model,User user,String nameRole){
        createUserServiceInterface.createUser(user,nameRole);
        user = new User();
        model.addAttribute("user",user);
        model.addAttribute("allRoles",arr);
        model.addAttribute("success","Пользователь добавлен");
        return "admin/createTest";
    }

    @GetMapping(value = "/createUser")
    public String createUser(Model model){
        User user  = new User();
        model.addAttribute("allUsers",service.findAll());
        model.addAttribute("user",user);
       model.addAttribute("allRoles", arr);
       return "admin/createUser";
    }

    @GetMapping("/createTest")
    public String createTest(Model model){
        return "admin/createTest";
    }

    @GetMapping(value = "/adminStatistic")
    public String adminStatistic(){
        return "admin/adminStatistic";
    }

    @GetMapping(value = "/goHomeAdmin")
    public String goHomeAdmin(){
        return "admin/admin";
    }
}
