package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.domain.person.Person;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PersonResourceModelAssembler implements RepresentationModelAssembler<Person, EntityModel<PersonResource>> {
    @Override
    public EntityModel<dev.accelerated.language.teacher.rest.controllers.persons.PersonResource> toModel(Person entity) {
        return EntityModel.of(
                dev.accelerated.language.teacher.rest.controllers.persons.PersonResource.fromPerson(entity),
                linkTo(methodOn(PersonController.class).one(entity.id().toString())).withSelfRel()
        );
    }

    @Override
    public CollectionModel<EntityModel<PersonResource>> toCollectionModel(Iterable<? extends Person> entities) {
        var modeledEntities = new LinkedList<EntityModel<dev.accelerated.language.teacher.rest.controllers.persons.PersonResource>>();
        for (var entity : entities) {
            modeledEntities.add(this.toModel(entity));
        }
        return CollectionModel
                .of(
                        modeledEntities,
                        linkTo(methodOn(PersonController.class).all(null)).withSelfRel()
                );
    }
}
