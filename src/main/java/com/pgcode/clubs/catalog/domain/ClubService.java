package com.pgcode.clubs.catalog.domain;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Goran Paunovic
 */

@Service
public class ClubService {
    private final ClubMapper clubMapper;
    private final ClubRepository clubRepository;
    private final GeometryFactory geometryFactory;

    public ClubService(ClubMapper clubMapper, ClubRepository clubRepository, GeometryFactory geometryFactory) {
        this.clubMapper = clubMapper;
        this.clubRepository = clubRepository;
        this.geometryFactory = geometryFactory;
    }

    public Iterable<ClubDto> getAllClubs() {
        return clubMapper.toDto(clubRepository.findAll());
    }

    public ClubDto getClub(Integer id) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
        return clubMapper.toDto(club);
    }

    public ClubDto createClub(ClubDto clubDto) {
        return clubMapper.toDto(clubRepository.save(clubMapper.toEntity(clubDto, geometryFactory)));
    }

    public ClubDto updateClub(Integer id, ClubDto clubDto) {
        // Fetch club from database
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));

        // Save changes
        return clubMapper.toDto(clubRepository.save(clubMapper.partialUpdate(clubDto, club)));
    }

    public Iterable<ClubDto> findNearbyClubs(double lat, double lon) {
        // Create a point object from the given latitude and longitude
        Geometry point = geometryFactory.createPoint( new Coordinate( lon, lat ) );

        // Create a query that finds all clubs within the given distance
        List<Club> nearbyClubs = clubRepository.findNearbyClubs(point, 10000);

        // Return the results
        return clubMapper.toDto(nearbyClubs);
    }

    public Iterable<ClubDto> searchClubs(String term) {
        // Create a query that finds all clubs within the given distance
        List<Club> nearbyClubs = clubRepository.searchClubs(term);

        // Return the results
        return clubMapper.toDto(nearbyClubs);
    }
}
