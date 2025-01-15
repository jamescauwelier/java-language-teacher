package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.rest.errors.PageParametersOutOfRangeException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
//        return assembler.toCollectionModel(result.getContent());
    }

//    @PostMapping("/persons")
//    ResponseEntity<?> register(){}
}
