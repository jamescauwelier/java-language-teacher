package dev.accelerated.language.teacher.infrastructure.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface PersonRecordRepository extends JpaRepository<PersonRecord, UUID> {
}
