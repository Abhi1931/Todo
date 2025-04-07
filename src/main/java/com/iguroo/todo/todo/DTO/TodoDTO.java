package com.iguroo.todo.todo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {

    private Long taskId;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 500, message = "Description can't exceed 500 characters")
    private String description;

    @NotNull(message = "Completion status is required")
    private boolean completed;

    @NotNull(message = "User ID is required")
    private Long user_id;
}
