package io.github.to_do_list.dto;


public record UserTaskDTO(Long id, String title, String description, boolean isCompleted) {
}
