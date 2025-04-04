package com.iguroo.todo.todo.Service;


import com.iguroo.todo.todo.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    ResponseEntity<?> loginUser(String username, String password);
}


