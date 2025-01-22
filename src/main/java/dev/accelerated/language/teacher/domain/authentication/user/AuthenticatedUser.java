package dev.accelerated.language.teacher.domain.authentication.user;

import java.util.UUID;

public record AuthenticatedUser(
        UUID personId
) {
}
