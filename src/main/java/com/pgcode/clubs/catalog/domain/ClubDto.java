package com.pgcode.clubs.catalog.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.locationtech.jts.geom.Point;

import java.io.Serializable;

/**
 * DTO for {@link Club}
 */
@Value
public class ClubDto implements Serializable {
    Integer id;

    @NotBlank(message = "The club name must be defined.")
    String name;

    String streetAddress;
    String city;
    String state;
    String postalCode;

    @NotBlank(message = "The country field must be defined.")
    String country;
    String phoneNumber;
    String email;
    String description;

    Double latitude;
    Double longitude;
}