package com.java.example.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class Todo {
    @Id
    private String id;

    @NotNull(message = "description can not be null")
    @Size(min = 3, max = 50, message = "description must be between 3 and 50")
    String description;

    @NotNull(message = "status can not be null and should be either New/In Progress/Done")
    TodoStatus status;

    Date CreatedOnDateTime;

    Date ModifiedOnDateTime;
}
