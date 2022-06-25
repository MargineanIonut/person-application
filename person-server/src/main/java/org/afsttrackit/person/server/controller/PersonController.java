package org.afsttrackit.person.server.controller;

import lombok.RequiredArgsConstructor;
import org.afsttrackit.person.server.entity.PersonEntity;
import org.afsttrackit.person.server.model.PersonFilter;
import org.afsttrackit.person.server.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("persons")
public class PersonController {

    private final PersonService service;

    @GetMapping
    List<PersonEntity> getAll(PersonFilter filter){
        return service.getAll(filter);
    }

    @PostMapping("filter")
    List<PersonEntity> getAllPost(@RequestBody PersonFilter filter){
        return service.getAll(filter);
    }

    @PostMapping
    PersonEntity createEntity(@RequestBody PersonEntity newEntity){
        return service.createEntity(newEntity);
    }

    @PutMapping("{id}")
    PersonEntity replaceEntity(@PathVariable int id, @RequestBody PersonEntity newEntity){
        return service.replaceEntity(id, newEntity);
    }

    @PatchMapping("{id}")
    PersonEntity updateEntity(@PathVariable int id, @RequestBody PersonEntity updatedEntity){
        return service.updateEntity(id, updatedEntity);
    }
}


