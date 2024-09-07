package com.pgcode.clubs.catalog.domain;

/**
 * @author Goran Paunovic
 */
public class ClubNotFoundException extends RuntimeException {
    public ClubNotFoundException(Integer id) {
        super("Club with id " + id + " not found");
    }
}
