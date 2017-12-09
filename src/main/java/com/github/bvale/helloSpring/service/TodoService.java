package com.github.bvale.helloSpring.service;

import com.github.bvale.helloSpring.domain.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();
    Todo findById(String id);
    Todo create(Todo todo);
    Todo update(Todo todo);
    void delete(String id);
}
