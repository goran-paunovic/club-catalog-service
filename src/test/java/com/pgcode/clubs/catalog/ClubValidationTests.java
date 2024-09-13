package com.pgcode.clubs.catalog;

import com.pgcode.clubs.catalog.domain.ClubDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Goran Paunovic
 */
class ClubValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    @Test
    void whenAllFieldsAreCorrectValidationSucceeds() {
        ClubDto clubDto = new ClubDto( null, "name", null, null, null, null, "Country", null, null, null, null, null );

        Set<ConstraintViolation<ClubDto>> violations = validator.validate(clubDto);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenTitleIsBlankValidationFails() {
        ClubDto clubDto = new ClubDto( null, null, null, null, null, null, "Country", null, null, null, null, null );

        Set<ConstraintViolation<ClubDto>> violations = validator.validate(clubDto);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The club name must be defined.");
    }
}
