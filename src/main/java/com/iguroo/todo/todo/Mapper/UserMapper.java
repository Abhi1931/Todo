package com.iguroo.todo.todo.Mapper;

import com.iguroo.todo.todo.DTO.UserDTO;
import com.iguroo.todo.todo.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
}


