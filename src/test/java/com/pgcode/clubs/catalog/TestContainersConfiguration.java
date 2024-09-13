package com.pgcode.clubs.catalog;

import com.pgcode.clubs.catalog.domain.Club;
import com.pgcode.clubs.catalog.domain.ClubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

/**
 * @author Goran Paunovic
 */
@Testcontainers
@SpringBootTest
class TestContainersConfiguration {
    @Autowired
    ClubRepository clubRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgis/postgis:15-3.4-alpine")
            .asCompatibleSubstituteFor("postgres"));

    @Test
    @Transactional
    void myTest() {
        clubRepository.saveAndFlush(Club.builder()
                        .name("Club name")
                        .city("Belgrade")
                        .country("Serbia")
                        .description("Tennis club description")
                        .postalCode("11000")
                .build());

        List<Club> clubs = clubRepository.findAll();
        assert clubs.size() == 1;
    }

}
