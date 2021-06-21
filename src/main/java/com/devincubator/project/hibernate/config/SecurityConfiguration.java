package com.devincubator.project.hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("com.devincubator.project.hibernate")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public CustomSuccessHandler customSuccessHandler(){
        return new CustomSuccessHandler();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception{
            auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select login,password,roleId from user where login=?")
                .authoritiesByUsernameQuery("select login,nameRole,roleId from user where login=?")
                .getUserDetailsService()
            ;
            //пароли как и username {2222,1234,1111} и в базе тоже самое Оказывается работает из базы данных
/*        auth.inMemoryAuthentication().withUser("2222").password("$2y$12$FhmGxAMwh8oOjxyoLOVVb.6b3RyFFLEha3TD6P8HPwfSh4tvu0QrG").roles("USER");
        auth.inMemoryAuthentication().withUser("1234").password("$2y$12$Faqf2wKmWo/YWEISCOkZlek.VboJDg4.ol2VpO.5ZoijSxmK7Xlbu").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("1111").password("$2y$12$kVCk/xrhd7ijLl/8nxphJOnWw/sgi8h724OXP1msk93pZBP.aTmwy").roles("TUTOR");*/
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/","/home","/user/**").access("hasRole('USER')")
                    .antMatchers("/admin/**").access("hasRole('ADMIN')")
                    .antMatchers("/tutor/**").access("hasRole('TUTOR')")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .loginProcessingUrl("/login") //value в login.jsp
                    .successHandler(customSuccessHandler())
                    .usernameParameter("ssoId") //name в login.jsp
                    .passwordParameter("password") //name в login.jsp
                    .permitAll()
                .and()
                    .csrf()
                .and()
                    .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied");
    }
}
