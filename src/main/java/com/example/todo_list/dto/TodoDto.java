package com.example.todo_list.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoDto {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private boolean completed;
}
