package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends JpaRepository<Person, String> {
}
