package com.github.bvale.helloSpring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "todos")
public class Todo {

    @Id private String id;
    private String description;
    private Boolean completed = false;

}
