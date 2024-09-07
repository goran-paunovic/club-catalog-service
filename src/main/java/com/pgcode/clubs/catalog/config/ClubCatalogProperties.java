package com.pgcode.clubs.catalog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Goran Paunovic
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "club")
public class ClubCatalogProperties {
    /**
     * A message to welcome users.
     */
    private String greeting;
}