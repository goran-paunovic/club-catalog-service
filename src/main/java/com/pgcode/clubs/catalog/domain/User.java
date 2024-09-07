package com.pgcode.clubs.catalog.domain;

import java.util.List;

/**
 * @author Goran Paunovic
 */

public record User(
    String username,
    String firstName,
    String lastName,
    List<String> roles
){}
