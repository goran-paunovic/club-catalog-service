package com.pgcode.clubs.catalog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Goran Paunovic
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.pgcode.clubs.catalog")
public class RepositoryConfig {
}
