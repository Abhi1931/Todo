package com.iguroo.todo.todo.ServiceImplementation;


import com.iguroo.todo.todo.DTO.TodoDTO;
import com.iguroo.todo.todo.Entity.Todo;
import com.iguroo.todo.todo.Entity.User;
import com.iguroo.todo.todo.Mapper.TodoMapper;
import com.iguroo.todo.todo.Repository.TodoRepo;
import com.iguroo.todo.todo.Repository.UserRepo;
import com.iguroo.todo.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {
        if (todoDTO.getUser_id() == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }

        User user = userRepo.findById(todoDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Todo todo = todoMapper.toEntity(todoDTO);
        todo.setUser(user); // make sure this line is here!

        Todo savedTodo = todoRepo.save(todo);
        System.out.println("User ID from DTO: " + todoDTO.getUser_id());

        return todoMapper.toDTO(savedTodo);
    }


    @Override
    public Optional<TodoDTO> updateTodo(Long taskId, TodoDTO updatedTodoDTO) {
        return todoRepo.findById(taskId).map(todo -> {
            todo.setTitle(updatedTodoDTO.getTitle());
            todo.setDescription(updatedTodoDTO.getDescription());
            todo.setCompleted(updatedTodoDTO.isCompleted());
            Todo updated = todoRepo.save(todo);
            return todoMapper.toDTO(updated);
        });
    }


    @Override
    public boolean deleteTodo(Long taskId) {
        if (!todoRepo.existsById(taskId)) {
            return false;
        }
        todoRepo.deleteById(taskId);
        return true;
    }

    @Override
    public List<TodoDTO> getTasksByUserId(Long userId) {
        List<Todo> todos = todoRepo.findByUser_Id(userId);
        return todos.stream().map(todoMapper::toDTO).toList();
    }


}
