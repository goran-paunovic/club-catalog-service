package com.pgcode.clubs.catalog;

import com.pgcode.clubs.catalog.domain.ClubDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() { }

//    @Test
//    void whenPostRequestThenClubCreated() {
//        ClubDto clubDto = new ClubDto( null, "Club 001", null, null, null, null, "Country", null, null, null );
//
//        webTestClient
//                .post()
//                .uri("/api/clubs")
//                .bodyValue(clubDto)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectBody(ClubDto.class).value(newClub -> {
//                    assertThat(newClub).isNotNull();
//                    assertThat(newClub.getId()).isNotNull();
//                    assertThat(newClub.getName()).isEqualTo(clubDto.getName());
//                });
//    }

}
