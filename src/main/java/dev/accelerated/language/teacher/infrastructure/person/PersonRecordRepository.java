package dev.accelerated.language.teacher.infrastructure.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface PersonRecordRepository extends JpaRepository<PersonRecord, String> {
}
