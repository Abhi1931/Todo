package com.iguroo.todo.todo.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private Long taskId;
    private String title;
    private String description;
    private boolean completed;
    private Long user_id;
}
