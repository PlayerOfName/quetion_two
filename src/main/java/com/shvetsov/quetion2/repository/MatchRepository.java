package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository for {@link Match}
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    /**
     * Method for getting the matches by id
     * @param id the date of the match
     * @return a list of matches
     */
    Match findAllById(Long id);

    /**
     * Method for getting the matches by date
     * @param date
     * @return
     */
    List<Match> findByDateMatch(Date date);
}
