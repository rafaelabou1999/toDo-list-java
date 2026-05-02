package io.github.to_do_list.dto;

import io.github.to_do_list.model.StatusTask;
import io.github.to_do_list.model.Task;
import io.github.to_do_list.model.User;

public record UserUpdateDTO(Long id, StatusTask status, Long userId) {
    public UserUpdateDTO(Task task){
        this(task.getId(), task.getStatus(), task.getUser().getId());
    }
}
