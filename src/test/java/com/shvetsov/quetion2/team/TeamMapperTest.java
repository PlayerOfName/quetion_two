package com.shvetsov.quetion2.team;

import com.shvetsov.quetion2.dto.team.TeamDTO;
import com.shvetsov.quetion2.mappers.TeamMapper;
import com.shvetsov.quetion2.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    public void testFromTeamCreateDto() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setName("TestTeam");

        Team team = teamMapper.fromTeamCreateDto(teamDTO);

        assertEquals("TestTeam", team.getName());
    }
}
