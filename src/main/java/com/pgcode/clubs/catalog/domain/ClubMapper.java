package com.pgcode.clubs.catalog.domain;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClubMapper {
    /**
     * Maps a {@link ClubDto} to a {@link Club} entity.
     *
     * @param clubDto the club DTO to map
     * @return the mapped club entity
     */
    @Mapping(source = ".", target = "location")
    Club toEntity(ClubDto clubDto, @Context GeometryFactory geomFactory);

    /**
     * Maps a {@link Club} entity to a {@link ClubDto} DTO.
     *
     * @param club the club entity to map
     * @return the mapped club DTO
     */
    @Mapping(source = "location.y", target = "latitude")
    @Mapping(source = "location.x", target = "longitude")
    ClubDto toDto(Club club);

    /**
     * Maps a collection of {@link Club} entities to a collection of {@link ClubDto} DTOs.
     *
     * @param clubs the collection of club entities to map
     * @return the mapped collection of club DTOs
     */
    Iterable<ClubDto> toDto(Iterable<Club> clubs);

    /**
     * Maps a {@link ClubDto} to a {@link Club} entity.
     *
     * <p>This method is used to update an existing club entity with the values of the provided club DTO.
     *
     * @param clubDto the club DTO to map
     * @param club    the club entity to update
     * @return the updated club entity
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    Club partialUpdate(ClubDto clubDto, @MappingTarget Club club);

    default Point toPoint(ClubDto clubDto, @Context GeometryFactory geomFactory) {
        return geomFactory.createPoint( new Coordinate( clubDto.getLongitude(), clubDto.getLatitude() ) );
    }
}