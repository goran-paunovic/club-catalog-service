package com.pgcode.clubs.catalog.config;

import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Goran Paunovic
 */
@Configuration
public class GeometryConfig {
    @Bean
    GeometryFactory geometryFactory() {
        return new GeometryFactory();
    }
}
