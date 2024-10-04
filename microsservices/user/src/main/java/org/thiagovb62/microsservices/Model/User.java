package org.thiagovb62.microsservices.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.thiagovb62.microsservices.Model.DTO.CreateUserDto;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_users")
@AllArgsConstructor
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;

    public User() {
    }


    public User(CreateUserDto userDTO) {
        this.name = userDTO.name();
        this.email = userDTO.email();
    }
}
