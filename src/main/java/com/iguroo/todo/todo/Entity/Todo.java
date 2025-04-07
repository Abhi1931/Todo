package com.iguroo.todo.todo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = "Title is required")
    @Column
    private String title;

    @Size(max = 500, message = "Description can't exceed 500 characters")
    @Column
    private String description;

    @NotNull(message = "Completion status is required")
    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Establish relationship
    private User user;
}

