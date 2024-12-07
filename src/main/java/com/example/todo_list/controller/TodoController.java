package com.example.todo_list.controller;

import com.example.todo_list.dto.TodoDto;
import com.example.todo_list.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoDto> getAllTodos() {
        return service.getAllTodos();
    }

    @PostMapping
    public TodoDto createTodo(@Valid @RequestBody TodoDto todoDto) {
        return service.createTodo(todoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        service.deleteTodoById(id);
    }
}
