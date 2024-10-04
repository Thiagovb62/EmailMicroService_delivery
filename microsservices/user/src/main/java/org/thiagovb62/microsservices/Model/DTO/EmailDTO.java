package org.thiagovb62.microsservices.Model.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.thiagovb62.microsservices.Model.User;

import java.util.UUID;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private UUID userid;
    private String subject;
    private String  emailTo;
    private String  text;
}
