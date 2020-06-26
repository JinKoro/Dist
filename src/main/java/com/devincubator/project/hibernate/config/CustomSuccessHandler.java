package com.devincubator.project.hibernate.config;

import com.devincubator.project.hibernate.controller.HomeController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomSuccessHandler.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            System.out.println("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority a :authorities
             ) {
            roles.add(a.getAuthority());
        }
        if(isDba(roles)){
            url = "/tutor";
        }else if(isAdmin(roles)){
            url = "/admin";
        }else if(isUser(roles)){
            url = "/user";
        }else{
            url = "/accessDenied";
        }
        return  url;
    }

    private boolean isUser(List<String> roles){
        if(roles.contains("ROLE_USER")){
            return true;
        }
        return false;
    }
    private boolean isAdmin(List<String> roles){
        if(roles.contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }
    private boolean isDba(List<String> roles){
        if(roles.contains("ROLE_TUTOR")){
            return true;
        }
        return false;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
