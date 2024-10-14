package com.shvetsov.quetion2;

import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.MatchRepository;
import com.shvetsov.quetion2.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Quetion2ApplicationTests {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Test
    void testCreateTeam() {
        Team team = new Team("testTeam");
        teamRepository.save(team);
        Team foundTeam = teamRepository.findById(team.getId()).orElseThrow();
        Assertions.assertEquals(team.getName(), foundTeam.getName());
    }
}
