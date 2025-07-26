package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.CreateTeamRequestDto;
import com.codeseek.footballmanager.dto.TeamDto;
import java.util.List;

public interface TeamService {
    TeamDto save(CreateTeamRequestDto requestDto);

    List<TeamDto> findAll();

    TeamDto findTeamById(Long id);

    TeamDto update(Long id, CreateTeamRequestDto requestDto);

    void deleteById(Long id);
}