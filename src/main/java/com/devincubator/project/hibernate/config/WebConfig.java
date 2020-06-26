package com.devincubator.project.hibernate.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.devincubator.project.hibernate")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@PropertySource("classpath:hibernate.properties")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/view/");
    }

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(environment.getProperty("database.url"));
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setDriverClassName(environment.getProperty("database.driverClassName"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(@Autowired DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("hibernate");
        localSessionFactoryBean.setHibernateProperties(createHibernateProperties());
        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    private Properties createHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.showSql", environment.getProperty("hibernate.showSql"));
        return properties;
    }


}
