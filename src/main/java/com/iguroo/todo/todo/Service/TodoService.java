package com.iguroo.todo.todo.Service;

import com.iguroo.todo.todo.DTO.TodoDTO;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    TodoDTO createTodo(TodoDTO todoDTO);        // Change to DTO

    Optional<TodoDTO> updateTodo(Long taskId, TodoDTO todoDTO);  // Change to DTO

    boolean deleteTodo(Long taskId);                // No change needed

    List<TodoDTO> getTasksByUserId(Long userId);

    //TodoDTO getTodoById(Long id);
}
