package com.shvetsov.quetion2.controllers;

import com.shvetsov.quetion2.dto.team.TeamDTO;
import com.shvetsov.quetion2.mappers.TeamMapper;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/team-api")
@RequiredArgsConstructor
public class TeamController {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @PostMapping("/create-team")
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO){
        Team team = teamMapper.fromTeamCreateDto(teamDTO);
        teamRepository.save(team);
        return ResponseEntity.ok(team);
    }
}
