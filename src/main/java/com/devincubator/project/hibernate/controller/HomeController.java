package com.devincubator.project.hibernate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @GetMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user",getPrincipal());
        return "admin/admin";
    }

    @GetMapping(value = "/user")
    public String userPage() {
        return "user";
    }

    @GetMapping(value = "/login")
    public String loginPage(ModelMap model){
        return "login";
    }


    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getPassword();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @GetMapping(value = "/accessDenied")
    public String access(){
        return "access_Denied";
    }


}
