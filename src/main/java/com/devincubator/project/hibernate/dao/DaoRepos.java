package com.devincubator.project.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRepos<T> {

    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public void save(T t);
    public List<T> findAll(Class T);

}
