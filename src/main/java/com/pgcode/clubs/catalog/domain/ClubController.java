package com.pgcode.clubs.catalog.domain;

import com.pgcode.clubs.catalog.config.ClubCatalogProperties;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Goran Paunovic
 */

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;
    private final ClubCatalogProperties clubCatalogProperties;

    public ClubController(ClubService clubService, ClubCatalogProperties clubCatalogProperties) {
        this.clubService = clubService;
        this.clubCatalogProperties = clubCatalogProperties;
    }

    /**
     * Retrieves all clubs from the database.
     *
     * @return an iterable of ClubDto
     */
    @GetMapping
    public Iterable<ClubDto> getAllClubs() {
        return clubService.getAllClubs();
    }

    /**
     * Finds all clubs that are within the given distance from the given location.
     *
     * @param lat  the latitude of the location
     * @param lon  the longitude of the location
     * @return an iterable of ClubDto
     */
    @GetMapping("/nearby")
    public Iterable<ClubDto> findNearbyClubs(@RequestParam double lat, @RequestParam double lon) {
        return clubService.findNearbyClubs(lat, lon);
    }

    @GetMapping("/search")
    public Iterable<ClubDto> searchClubs(@RequestParam String term) {
        return clubService.searchClubs(term);
    }

    @GetMapping("{id}")
    public ClubDto getClubById(@PathVariable Integer id) {
        return clubService.getClub(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDto createClub(@Valid @RequestBody ClubDto clubDto) {
        return clubService.createClub(clubDto);
    }

    @PutMapping("{id}")
    public ClubDto updateClub(@PathVariable Integer id, @Valid @RequestBody ClubDto clubDto) {
        return clubService.updateClub(id, clubDto);
    }

    @GetMapping("/greet")
    public String getGreeting() {
        return clubCatalogProperties.getGreeting();
    }
}
