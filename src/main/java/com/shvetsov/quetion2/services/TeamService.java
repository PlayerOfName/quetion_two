package com.shvetsov.quetion2.services;

import com.shvetsov.quetion2.models.Team;
import com.shvetsov.quetion2.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

}
