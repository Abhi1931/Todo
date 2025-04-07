package com.iguroo.todo.todo.Controller;

import com.iguroo.todo.todo.DTO.LoginDTO;
import com.iguroo.todo.todo.DTO.UserDTO;
import com.iguroo.todo.todo.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        ResponseEntity<?> response = userService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
        return ResponseEntity.ok(response);
    }


//        @PostMapping("/login")  // ✅ Ensure it's POST
//        public ResponseEntity<?> loginUser(@RequestBody LoginDTO login) {
//            // Authentication logic here
//            if ("testUser".equals(login.getUsername()) && "testPass".equals(login.getPassword())) {
//                return ResponseEntity.ok(Map.of("success", true));
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false));
//            }
//        }
}

