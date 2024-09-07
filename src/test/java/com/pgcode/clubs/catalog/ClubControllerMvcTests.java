package com.pgcode.clubs.catalog;

import com.pgcode.clubs.catalog.domain.ClubController;
import com.pgcode.clubs.catalog.domain.ClubNotFoundException;
import com.pgcode.clubs.catalog.domain.ClubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Goran Paunovic
 */

@WebMvcTest(ClubController.class)
class ClubControllerMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClubService clubService;

    @Test
    void whenGetClubNotExistsThenShouldReturn404() throws Exception {
        Integer id = 0;

        given(clubService.getClub(id))
                .willThrow(ClubNotFoundException.class);

        mockMvc.perform(get("/api/clubs/" + id))
                .andExpect(status().isNotFound());
    }
}
