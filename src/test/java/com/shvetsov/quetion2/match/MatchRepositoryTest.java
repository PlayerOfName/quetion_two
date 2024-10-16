package com.shvetsov.quetion2.match;

import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.MatchRepository;
import com.shvetsov.quetion2.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Match repository test.
 */
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchRepositoryTest {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    /**
     * Test find all by date match null.
     *
     * @throws ParseException the parse exception
     */
    @Test
    public void testFindAllByDateMatchNull() throws ParseException {
        Team homeTeam = teamRepository.save(new Team(1L, "TestTeam"));
        Team awayTeam = teamRepository.save(new Team(2L, "TestTeam2"));
        Team homeTeam2 = teamRepository.save(new Team(3L, "TestTeam3"));
        Team awayTeam2 = teamRepository.save(new Team(4L, "TestTeam4"));

        Match match = new Match();
        match.setId(1L);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        match.setSeason("TestSeason");
        match.setNumberPointsHomeTeam(1);
        match.setNumberPointsAwayTeam(2);

        Match match2 = new Match();
        match2.setId(2L);
        match2.setHomeTeam(homeTeam2);
        match2.setAwayTeam(awayTeam2);
        match2.setDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));
        match2.setSeason("TestSeason2");
        match2.setNumberPointsHomeTeam(12);
        match2.setNumberPointsAwayTeam(22);

        matchRepository.save(match);
        matchRepository.save(match2);

        List<Match> foundMatch = matchRepository.findAllByDateMatch(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"));

        assertFalse(foundMatch.isEmpty());

        assertEquals("TestTeam", foundMatch.getFirst().getHomeTeam().getName());
        assertEquals("TestTeam2", foundMatch.getFirst().getAwayTeam().getName());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"), foundMatch.getFirst().getDateMatch());
        assertEquals("TestSeason", foundMatch.getFirst().getSeason());
        assertEquals(1, foundMatch.getFirst().getNumberPointsHomeTeam());
        assertEquals(2, foundMatch.getFirst().getNumberPointsAwayTeam());

        assertEquals("TestTeam3", foundMatch.getLast().getHomeTeam().getName());
        assertEquals("TestTeam4", foundMatch.getLast().getAwayTeam().getName());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"), foundMatch.getLast().getDateMatch());
        assertEquals("TestSeason2", foundMatch.getLast().getSeason());
        assertEquals(12, foundMatch.getLast().getNumberPointsHomeTeam());
        assertEquals(22, foundMatch.getLast().getNumberPointsAwayTeam());
    }
}
