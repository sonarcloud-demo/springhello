package com.github.bvale.helloSpring.service.impl;

import com.github.bvale.helloSpring.domain.Todo;
import com.github.bvale.helloSpring.repositories.TodoRepository;
import com.github.bvale.helloSpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() { return this.todoRepository.findAll(); }

    @Override
    public Todo findById(String id) { return this.todoRepository.findOne(id);}

    @Override
    public Todo create(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public void delete(String id) {
        this.todoRepository.delete(id);
    }
}
