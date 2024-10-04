package org.ms.email.DTO;

import java.util.UUID;

public record EmailRequestDTO(
        UUID userid,
        String emailTo,
        String subject,
        String text
) {
}
