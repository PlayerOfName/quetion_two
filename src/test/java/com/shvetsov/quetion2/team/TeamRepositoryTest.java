package com.shvetsov.quetion2.team;

import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Team repository test.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    /**
     * Test find all by id.
     */
    @Test
    public void testFindAllById() {
        Team team = new Team();
        team.setName("TestTeam");
        teamRepository.save(team);

        Optional<Team> foundTeam = teamRepository.findById(team.getId());
        assertTrue(foundTeam.isPresent());
        assertEquals("TestTeam", foundTeam.get().getName());

        teamRepository.delete(team);
    }

    /**
     * Test find by name.
     */
    @Test
    public void testFindByName() {
        Team team = new Team();
        team.setName("TestTeam");
        teamRepository.save(team);

        Optional<Team> foundTeam = teamRepository.findByName("TestTeam");
        assertTrue(foundTeam.isPresent());
        assertEquals("TestTeam", foundTeam.get().getName());

        teamRepository.delete(team);
    }
}

