package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.model.Team;

public interface InternalTeamService {
    Team getEntityById(Long id);
    Team saveEntity(Team team);
}
