package com.iguroo.todo.todo.ServiceImplementation;

import com.iguroo.todo.todo.DTO.UserDTO;
import com.iguroo.todo.todo.Entity.User;
import com.iguroo.todo.todo.Mapper.UserMapper;
import com.iguroo.todo.todo.Repository.UserRepo;
import com.iguroo.todo.todo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper; // Mapper to convert User to UserDTO

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        userRepo.save(user);  // ✅ Save user without encrypting password
        return userMapper.toDTO(user);
    }

    @Override
    public ResponseEntity<?> loginUser(String username, String password) {
        Optional<User> user = userRepo.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            Long userId = user.get().getId(); // ✅ Get userId
            return ResponseEntity.ok(Collections.singletonMap("userId", userId)); // ✅ Return userId
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
