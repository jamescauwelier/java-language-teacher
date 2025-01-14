package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public Page<Person> findAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
