package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * this repository for team
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    /**
     * mehod for find team by id
     * @param id
     * @return
     */
    Team findAllById(Long id);

    /**
     * method for find team by name
     * @param name
     * @return
     */
    Optional<Team> findByName(String name);
}
