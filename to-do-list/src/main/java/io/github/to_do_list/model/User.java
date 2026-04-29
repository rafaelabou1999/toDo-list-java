package io.github.to_do_list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.to_do_list.dto.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Task> allTasks;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(UserUpdateDTO dto) {
        this.id = dto.userId();
    }
}
