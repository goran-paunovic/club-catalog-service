package com.pgcode.clubs.catalog.domain;

import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Goran Paunovic
 */

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

    @Query(value = "SELECT c FROM Club c WHERE ST_Distance(c.location, :point) <= :distanceInMeters")
    List<Club> findNearbyClubs(@Param("point") Geometry point, @Param("distanceInMeters") int distanceInMeters);

    @Query(value = "SELECT * " +
            "FROM clubs " +
            "WHERE club_search_vector @@ websearch_to_tsquery(:term) " +
            "order by ts_rank(club_search_vector, websearch_to_tsquery(:term), 1) DESC",
            nativeQuery = true)
    List<Club> searchClubs(String term);
}
