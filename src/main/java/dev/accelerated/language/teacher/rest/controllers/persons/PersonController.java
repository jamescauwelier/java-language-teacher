package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.rest.errors.PageParametersOutOfRangeException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PersonController {
    PersonService service;
    PersonModelAssembler assembler;
    PagedPersonModelAssembler personAssembler;

    PersonController(
            PersonService personService,
            PersonModelAssembler assembler
    ) {
        this.service = personService;
        this.assembler = assembler;
        this.personAssembler = new PagedPersonModelAssembler();
    }

    @GetMapping("/persons")
    public CollectionModel<EntityModel<Person>> all(@PageableDefault(page = 0, size = 10) Pageable page) {
        var query = new FindAllPersons(page.getPageNumber(), page.getPageSize());
        Page<Person> result = service.findAll(query);
        if (result.getTotalPages() < page.getPageNumber() && page.getPageNumber() != 0) {
            throw new PageParametersOutOfRangeException(page.getPageNumber(), result.getTotalPages());
        }

        return personAssembler.toPagedPersonModel(result, assembler);
    }

    @PostMapping("/persons")
    public ResponseEntity<EntityModel<Person>> register(@RequestBody RegisterPersonCommand command) {
        var person = service.createPerson(command);
        var model = assembler.toModel(person);

        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @GetMapping("/persons/{personId}")
    public ResponseEntity<EntityModel<Person>> one(@PathVariable String personId) {
        var person = service.findById(new FindPersonById(UUID.fromString(personId))).get();
        var model = assembler.toModel(person);

        return ResponseEntity
                .ok()
                .body(model);
    }
}
