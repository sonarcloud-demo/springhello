package com.github.bvale.helloSpring.controller;

import com.github.bvale.helloSpring.domain.Todo;
import com.github.bvale.helloSpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) { this.todoService = todoService;}


    @ResponseBody
    @GetMapping
    public List<Todo> getAllTodos(){
        return this.todoService.findAll();
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> create(@Valid @RequestBody Todo todo){
        todoService.create(todo);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(todo.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

}
