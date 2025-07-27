package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.CreatePlayerRequestDto;
import com.codeseek.footballmanager.dto.PlayerDto;
import java.util.List;

public interface PlayerService {
    PlayerDto save(CreatePlayerRequestDto requestDto);
    List<PlayerDto> findAll();
    PlayerDto findPlayerById(Long id);
    PlayerDto update(Long id, CreatePlayerRequestDto requestDto);
    void deleteById(Long id);
    List<PlayerDto> getPlayersByTeamId(Long teamId);
}
