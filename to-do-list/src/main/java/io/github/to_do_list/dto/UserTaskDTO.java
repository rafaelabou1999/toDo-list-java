package io.github.to_do_list.dto;


import io.github.to_do_list.model.User;

public record UserTaskDTO(Long id, String title, String description, boolean isCompleted, Long userId) {
}
