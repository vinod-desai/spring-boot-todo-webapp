package com.java.example.service;

import com.java.example.dao.TodoRepository;
import com.java.example.exception.TodoNotFoundException;
import com.java.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ServiceMessageQueue serviceMessageQueue;

    public List<Todo> getTodos() {
        this.serviceMessageQueue.sendMessage("getTodos called");
        return todoRepository.findAll();
    }

    public Todo getTodo(String id) throws TodoNotFoundException {
        Optional<Todo> existingTodo = getTodoFromDB(id);
        if(existingTodo.isPresent()){
            return existingTodo.get();
        } else {
            throw getTodoNotFoundException(id);
        }
    }

    public Todo createTodo(Todo todo) {
        todo.setCreatedOnDateTime(Date.from(Instant.now()));
        todo.setModifiedOnDateTime(Date.from(Instant.now()));
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo todo) throws TodoNotFoundException {
        Optional<Todo> existingTodo = getTodoFromDB(id);
        if(existingTodo.isPresent()){
            todo.setCreatedOnDateTime(existingTodo.get().getCreatedOnDateTime());
            todo.setModifiedOnDateTime(Date.from(Instant.now()));
            return todoRepository.save(todo);
        } else {
            throw getTodoNotFoundException(id);
        }
    }

    public void deleteTodo(String id) throws TodoNotFoundException {
        Optional<Todo> existingTodo = getTodoFromDB(id);
        if(existingTodo.isPresent()){
            todoRepository.deleteById(id);
        } else {
            throw getTodoNotFoundException(id);
        }
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    private Optional<Todo> getTodoFromDB(String id) {
        return todoRepository.findById(id);
    }

    private TodoNotFoundException getTodoNotFoundException(String id) {
        return new TodoNotFoundException(MessageFormat.format("Todo {0} not exist", id));
    }
}
