package org.thiagovb62.microsservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thiagovb62.microsservices.Model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
