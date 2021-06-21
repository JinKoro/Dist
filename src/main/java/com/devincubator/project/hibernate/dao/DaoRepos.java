package com.devincubator.project.hibernate.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DaoRepos<T> {

    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public void save(T t);
    public List<T> findAll();

}
