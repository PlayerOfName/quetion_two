package com.shvetsov.quetion2.mappers;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.models.Match;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * mapper for match
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatchMapper {

    /**
     * method for mapping from {@link MatchDTO} to {@link Match}
     * @param matchDTO instance of {@link MatchDTO}
     * @return instance of {@link Match}
     */
    Match fromMatchCreateDto(MatchDTO matchDTO);
}
