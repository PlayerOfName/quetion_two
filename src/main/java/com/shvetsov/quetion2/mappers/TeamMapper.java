package com.shvetsov.quetion2.mappers;

import com.shvetsov.quetion2.dto.team.TeamDTO;
import com.shvetsov.quetion2.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

/**
 * mapper for team
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    /**
     * Mapping from {@link TeamDTO} to {@link Team}
     * @param teamDTO instance of {@link TeamDTO}
     * @return instance of {@link Team}
     */
    @Mapping(target = "name", source = "teamName")
    Team fromTeamCreateDto(TeamDTO teamDTO);
}
