package com.github.bvale.helloSpring.repositories;

import com.github.bvale.helloSpring.domain.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

    @Query("{completed: true}")
    List<Todo> findAllCompleted();

    @Query("{completed: false}")
    List<Todo> findAllActive();
}
