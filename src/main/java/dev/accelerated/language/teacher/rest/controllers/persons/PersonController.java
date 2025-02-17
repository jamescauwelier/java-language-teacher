package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.rest.errors.PageParametersOutOfRangeException;
import jakarta.validation.Valid;
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
    PersonResourceModelAssembler assembler;
    PagedPersonResourceModelAssembler personAssembler;

    PersonController(
            PersonService personService,
            PersonResourceModelAssembler assembler
    ) {
        this.service = personService;
        this.assembler = assembler;
        this.personAssembler = new PagedPersonResourceModelAssembler();
    }

    @GetMapping("/persons")
    public CollectionModel<EntityModel<PersonResource>> all(@PageableDefault(page = 0, size = 10) Pageable page) {

        var query = new FindAllPersons(page.getPageNumber(), page.getPageSize());
        Page<Person> result = service.findAll(query);
        if (result.getTotalPages() < page.getPageNumber() && page.getPageNumber() != 0) {
            throw new PageParametersOutOfRangeException(page.getPageNumber(), result.getTotalPages());
        }

        return personAssembler.toPagedPersonModel(result, assembler);
    }

    @PostMapping("/persons")
    public ResponseEntity<EntityModel<PersonResource>> register(@Valid @RequestBody RegisterPersonCommand command) {
        var person = service.registerPerson(command);
        var model = assembler.toModel(person);

        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @GetMapping("/persons/{personId}")
    public ResponseEntity<EntityModel<PersonResource>> one(@PathVariable String personId) {
        var person = service.findById(new FindPersonById(UUID.fromString(personId))).get();
        var model = assembler.toModel(person);

        return ResponseEntity
                .ok()
                .body(model);
    }
}
