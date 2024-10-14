package com.shvetsov.quetion2.match;

import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSaveAndFindMatch() {
        Team homeTeam = new Team("HomeTeam");
        Team awayTeam = new Team("AwayTeam");

        Match match = new Match();
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setDateMatch(new Date());
        match.setSeason("2024");
        match.setNumberPointsHomeTeam(3);
        match.setNumberPointsAwayTeam(1);

        entityManager.persist(homeTeam);
        entityManager.persist(awayTeam);
        entityManager.persist(match);
        entityManager.flush();

        Match found = entityManager.find(Match.class, match.getId());
        assertNotNull(found);
        assertEquals("HomeTeam", found.getHomeTeam().getName());
        assertEquals("AwayTeam", found.getAwayTeam().getName());
        assertEquals("2024", found.getSeason());
        assertEquals(3, found.getNumberPointsHomeTeam());
        assertEquals(1, found.getNumberPointsAwayTeam());
    }
}

