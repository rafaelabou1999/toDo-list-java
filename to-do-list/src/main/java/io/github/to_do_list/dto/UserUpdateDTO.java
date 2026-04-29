package io.github.to_do_list.dto;

import io.github.to_do_list.model.User;

public record UserUpdateDTO(Long id, boolean isCompleted, Long userId) {

}
