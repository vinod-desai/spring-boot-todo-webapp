package com.java.example.controller;

import com.java.example.exception.TodoNotFoundException;
import com.java.example.model.Todo;
import com.java.example.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @RequestMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodo(@PathVariable String id) throws TodoNotFoundException {
        return todoService.getTodo(id);
    }

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        todo.setId(null);
        return todoService.createTodo(todo);
    }

    @PutMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable String id, @Valid @RequestBody Todo todo) throws TodoNotFoundException {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable String id) throws TodoNotFoundException {
        todoService.deleteTodo(id);
    }

    @DeleteMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllTodos() {
        todoService.deleteAllTodos();
    }
}
