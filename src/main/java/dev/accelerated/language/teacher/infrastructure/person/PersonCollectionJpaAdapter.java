package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class PersonCollectionJpaAdapter implements PersonCollectionPort {
    PersonRepository repository;

    @Override
    public Person add(Person person) {
        return repository.save(person);
    }

    @Override
    public Optional<Person> get(UUID personId) {
        return repository.findById(personId);
    }


}
