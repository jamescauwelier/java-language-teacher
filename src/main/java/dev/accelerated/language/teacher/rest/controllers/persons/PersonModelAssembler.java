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
public class PersonModelAssembler implements RepresentationModelAssembler<Person, EntityModel<Person>> {
    @Override
    public EntityModel<Person> toModel(Person entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(PersonController.class).all(null)).withSelfRel()
        );
    }

    @Override
    public CollectionModel<EntityModel<Person>> toCollectionModel(Iterable<? extends Person> entities) {
        var modeledEntities = new LinkedList<EntityModel<Person>>();
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
