package org.afsttrackit.person.server.service;

import lombok.*;
import org.afsttrackit.person.server.entity.PersonEntity;
import org.afsttrackit.person.server.exception.ResourceNotFoundException;
import org.afsttrackit.person.server.model.PersonFilter;
import org.afsttrackit.person.server.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<PersonEntity> getAll(PersonFilter filter) {
        return repository.findAll().stream()
                .filter(person-> applyNameFilter(filter, person))
                .filter(person-> filter.minAge() == null || person.getAge() >= filter.minAge())
                .toList();

    }

    private boolean applyNameFilter(PersonFilter filter, PersonEntity person) {
        return filter.name() == null
                || filter.name().stream()
                .allMatch(name -> person.getName().contains(name));
    }

    public PersonEntity replaceEntity(int id, PersonEntity newEntity) {
        PersonEntity dbEntity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find person with id %s".formatted(id)));
//       return repository.save(dbEntity.toBuilder()
//               .age(newEntity.getAge())
//               .name(newEntity.getName())
//               .build());

        return repository.save(dbEntity
                .withName(newEntity.getName())
                .withAge(newEntity.getAge()));
    }

    public PersonEntity createEntity(PersonEntity newEntity) {
        validatePerson(newEntity);
        return repository.save(newEntity.withId(0));
    }

    private void validatePerson(PersonEntity newEntity) {
    }
}
