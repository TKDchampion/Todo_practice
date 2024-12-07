package com.example.todo_list.service;

import com.example.todo_list.dto.TodoDto;
import com.example.todo_list.entity.Todo;
import com.example.todo_list.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoDto> getAllTodos() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TodoDto createTodo(TodoDto dto) {
        Todo todo = convertToEntity(dto);
        return convertToDto(repository.save(todo));
    }

    public void deleteTodoById(Long id) {
        repository.deleteById(id);
    }

    private TodoDto convertToDto(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }

    private Todo convertToEntity(TodoDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setCompleted(dto.isCompleted());
        return todo;
    }
}
