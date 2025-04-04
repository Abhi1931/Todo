package com.iguroo.todo.todo.Mapper;

import com.iguroo.todo.todo.DTO.TodoDTO;
import com.iguroo.todo.todo.Entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    // ✅ Convert Entity → DTO
    @Mapping(source = "user.id", target = "user_id")
    TodoDTO toDTO(Todo todo);

    // ✅ Convert DTO → Entity (User mapping is manual)
    @Mapping(target = "user", ignore = true)
    // Ignore user (we handle it in service)
    Todo toEntity(TodoDTO todoDTO);
}

