package org.afsttrackit.person.server.model;

import java.util.List;

public record PersonFilter(
        List<String> name,
        Integer minAge,
        Integer maxAge){

}