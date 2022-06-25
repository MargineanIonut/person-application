package org.afsttrackit.person.server.repository;

import org.afsttrackit.person.server.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

}
