package com.vh.curriculum_back.models.users.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthDto(@NotBlank String login, @NotBlank String password) {
}
