package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Match;
import io.micrometer.common.lang.NonNullApi;
import lombok.NonNull;
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
     * Method for getting the matches by date
     * @param date
     * @return list of matches
     */
    List<Match> findAllByDateMatch(Date date);
}
