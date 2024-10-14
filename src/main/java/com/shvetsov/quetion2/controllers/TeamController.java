package com.shvetsov.quetion2.controllers;

import com.shvetsov.quetion2.dto.team.TeamDTO;
import com.shvetsov.quetion2.mappers.TeamMapper;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Team controller.
 */
@RestController()
@RequiredArgsConstructor
public class TeamController {

    /**
     * The Team repository.
     */
    private final TeamRepository teamRepository;

    /**
     * The Team mapper.
     */
    private final TeamMapper teamMapper;

    /**
     * Create team response entity.
     *
     * @param teamDTO the team dto
     * @return the response entity
     */
    @PostMapping("/create-team")
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO){
        Team team = teamMapper.fromTeamCreateDto(teamDTO);
        teamRepository.save(team);
        return ResponseEntity.ok(team);
    }
}
