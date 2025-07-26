package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.CreateTeamRequestDto;
import com.codeseek.footballmanager.dto.TeamDto;
import com.codeseek.footballmanager.exception.EntityNotFoundException;
import com.codeseek.footballmanager.mapper.TeamMapper;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.repository.TeamRepository;
import com.codeseek.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    @Override
    public TeamDto save(CreateTeamRequestDto requestDto) {
        Team team = teamRepository.save(teamMapper.toModel(requestDto));
        return teamMapper.toDto(team);
    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepository
                .findAll()
                .stream()
                .map(teamMapper::toDto)
                .toList();
    }

    @Override
    public TeamDto findTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such team with id " + id));

        return teamMapper.toDto(team);
    }

    @Override
    public TeamDto update(Long id, CreateTeamRequestDto requestDto) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such team with id " + id));

        teamMapper.updateTeamFromDto(requestDto, team);
        return teamMapper.toDto(teamRepository.save(team));
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);

    }
}
