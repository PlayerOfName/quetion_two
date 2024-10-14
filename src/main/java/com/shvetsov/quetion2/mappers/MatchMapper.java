package com.shvetsov.quetion2.mappers;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.models.Match;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MatchMapper {
    Match fromMatchCreateDto(MatchDTO matchDTO);
}
