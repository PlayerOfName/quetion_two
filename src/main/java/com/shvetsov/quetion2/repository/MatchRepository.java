package com.shvetsov.quetion2.repository;

import com.shvetsov.quetion2.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Match findAllById(Long id);
    List<Match> findByDate(Date date);
}
