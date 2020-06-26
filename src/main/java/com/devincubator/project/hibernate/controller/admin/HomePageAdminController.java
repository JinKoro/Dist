package com.devincubator.project.hibernate.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageAdminController {

    @GetMapping(value = "/createTest")
    public String createTest(){
        return "admin/createTest";
    }


    @GetMapping(value = "/createUser")
    public String createUser(){
        return "admin/createUser";
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
