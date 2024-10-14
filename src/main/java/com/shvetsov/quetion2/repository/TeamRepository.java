package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findAllById(Long id);
    Optional<Team> findByName(String name);
}
