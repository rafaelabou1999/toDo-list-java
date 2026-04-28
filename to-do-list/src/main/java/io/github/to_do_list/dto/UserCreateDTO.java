package io.github.to_do_list.dto;


import lombok.AllArgsConstructor;

public record UserCreateDTO(Long id, String title, String description, boolean isCompleted) {
}
