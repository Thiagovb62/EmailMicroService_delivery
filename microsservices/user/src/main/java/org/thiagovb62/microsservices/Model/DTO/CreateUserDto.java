package org.thiagovb62.microsservices.Model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email
) {
}
