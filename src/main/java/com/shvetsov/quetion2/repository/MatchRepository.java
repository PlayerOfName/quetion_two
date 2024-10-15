package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link Match}
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    /**
     * Method for getting the matches by id
     *
     * @param id the date of the match
     * @return a list of matches
     */
    Optional<Match> findById(Long id);

    /**
     * Method for getting the matches by date
     * @param date
     * @return list of matches
     */
    List<Match> findAllByDateMatch(Date date);
}
