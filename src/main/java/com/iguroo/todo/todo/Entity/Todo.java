package com.iguroo.todo.todo.Entity;

import jakarta.persistence.*;
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

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Establish relationship
    private User user;
}

