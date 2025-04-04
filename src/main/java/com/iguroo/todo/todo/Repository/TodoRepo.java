package com.iguroo.todo.todo.Repository;

import com.iguroo.todo.todo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    List<Todo> findByUser_Id(Long user_id);
}
