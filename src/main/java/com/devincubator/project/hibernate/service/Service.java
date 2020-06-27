package com.devincubator.project.hibernate.service;

import org.springframework.stereotype.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<T> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    public void save(T t);
    public List<T> findAll();

}
