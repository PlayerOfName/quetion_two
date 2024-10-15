package com.shvetsov.quetion2.team;

import com.shvetsov.quetion2.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSaveAndFindTeam() {
        Team team = new Team("Team");
        entityManager.persist(team);
        entityManager.flush();

        Team found = entityManager.find(Team.class, team.getId());
        assertNotNull(found);
        assertEquals("Team", found.getName());
    }
}
