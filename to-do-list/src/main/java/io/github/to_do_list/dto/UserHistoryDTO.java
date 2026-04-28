package io.github.to_do_list.dto;

import io.github.to_do_list.model.Task;
import io.github.to_do_list.model.User;

import java.util.List;

public record UserHistoryDTO(List<Task> allTasks) {
    public UserHistoryDTO(User user){
        this(user.getAllTasks());
    }
}
