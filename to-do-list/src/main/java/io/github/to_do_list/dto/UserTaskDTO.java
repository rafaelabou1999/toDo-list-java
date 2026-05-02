package io.github.to_do_list.dto;


import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.model.User;

import java.time.LocalDate;

public record UserTaskDTO(Long id, String title, String description, Long userId, StatusTask status, LocalDate createdAt) {

    public UserTaskDTO(Task task){
        this(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getUser().getId(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

}
