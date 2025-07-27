package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.exception.EntityNotFoundException;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.repository.TeamRepository;
import com.codeseek.footballmanager.service.InternalTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternalTeamServiceImpl implements InternalTeamService {
    private final TeamRepository teamRepository;

    @Override
    public Team getEntityById(Long id) {
        return teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such team with id " + id));
    }

    @Override
    public Team saveEntity(Team team) {
        return teamRepository.save(team);
    }
}
