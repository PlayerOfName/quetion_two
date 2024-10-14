package com.shvetsov.quetion2.controllers;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.mappers.MatchMapper;
import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.StatisticsTeam;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.MatchRepository;
import com.shvetsov.quetion2.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController("/match-api")
@RequiredArgsConstructor
public class MatchController {
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final MatchService matchService;

    @PostMapping("/create-match")
    public ResponseEntity<Match> createMatch(@RequestBody MatchDTO matchDTO){
        Match match = matchMapper.fromMatchCreateDto(matchDTO);
        matchRepository.save(match);
        return ResponseEntity.ok(match);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getTournamentTable(@RequestParam Date date){
        Map<String, StatisticsTeam> team = matchService.getStandings(date);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
