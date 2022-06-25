package org.afsttrackit.person.server.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@With
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int age;

    public PersonEntity(String name, int age){
        this(0,name,age);
    }
}
