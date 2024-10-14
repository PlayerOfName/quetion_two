package com.shvetsov.quetion2.controllers;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.error.NotFoundTeam;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * The type Match controller.
 */
@RestController()
@RequiredArgsConstructor
public class MatchController {


    /**
     * The Match repository.
     */
    private final MatchRepository matchRepository;

    /**
     * The match mapper.
     */
    private final MatchMapper matchMapper;

    /**
     * The Match service.
     */
    private final MatchService matchService;

    /**
     * Create match response entity.
     *
     * @param matchDTO the match dto
     * @return the response entity
     */
    @PostMapping("/create-match")
    public ResponseEntity<Match> createMatch(@RequestBody MatchDTO matchDTO) throws NotFoundTeam {
        return ResponseEntity.ok(matchService.createMatch(matchDTO));
    }

    /**
     * Get tournament table response entity.
     *
     * @param date the date
     * @return the response entity
     */
    @GetMapping("/get")
    public ResponseEntity<?> getTournamentTable(@RequestParam String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, StatisticsTeam> team = matchService.getStandings(format.parse(date));
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
