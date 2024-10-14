package com.shvetsov.quetion2.mappers;

import com.shvetsov.quetion2.dto.team.TeamDTO;
import com.shvetsov.quetion2.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    Team fromTeamCreateDto(TeamDTO teamDTO);
}
