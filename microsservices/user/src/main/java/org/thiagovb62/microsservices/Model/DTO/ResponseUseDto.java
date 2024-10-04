package org.thiagovb62.microsservices.Model.DTO;

import org.thiagovb62.microsservices.Model.User;

import java.util.UUID;

public record ResponseUseDto(
        UUID id,
        String name,
        String email

) {
    public ResponseUseDto(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
