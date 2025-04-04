package com.iguroo.todo.todo.Controller;


import com.iguroo.todo.todo.DTO.TodoDTO;
import com.iguroo.todo.todo.Entity.Todo;
import com.iguroo.todo.todo.Repository.TodoRepo;
import com.iguroo.todo.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "*") // Optional: for frontend dev
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Todo>> getUserTodos(@PathVariable Long userId) {
        List<Todo> todos = todoRepo.findByUser_Id(userId); // ✅ Fetch todos by userId
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/{user_id}")
    public ResponseEntity<TodoDTO> createTodo(@PathVariable Long user_id, @RequestBody TodoDTO todoDTO) {
        if (user_id == null) {
            throw new IllegalArgumentException("User ID must not be null in path variable");
        }
        todoDTO.setUser_id(user_id); // ✅ Assign path variable user_id to DTO
        TodoDTO createdTodo = todoService.createTodo(todoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long taskId, @RequestBody TodoDTO todo) {
        todo.setTaskId(taskId);
        return todoService.updateTodo(taskId, todo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long taskId) {
        if (todoService.deleteTodo(taskId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
