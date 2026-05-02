package io.github.to_do_list.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false, name="is_completed")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    private LocalDate createdAt;


    public Task(Long id, String title, String description, User user, boolean isCompleted, StatusTask status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.isCompleted = isCompleted;
        this.status = status;
        this.createdAt = LocalDate.now();
    }


}

/*
    {
        "title": "Do the dishes",
        "description": "I should do the dishes",
        "isCompleted": false,
        "status": "PENDING",

    }
*
 */
