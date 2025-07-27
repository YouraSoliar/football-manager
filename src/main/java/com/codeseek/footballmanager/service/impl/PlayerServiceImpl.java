package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.CreatePlayerRequestDto;
import com.codeseek.footballmanager.dto.PlayerDto;
import com.codeseek.footballmanager.exception.EntityNotFoundException;
import com.codeseek.footballmanager.mapper.PlayerMapper;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDto save(CreatePlayerRequestDto requestDto) {
        Player player = playerMapper.toModel(requestDto);
        return playerMapper.toDto(playerRepository.save(player));
    }

    @Override
    public List<PlayerDto> findAll() {
        return playerRepository
                .findAll()
                .stream()
                .map(playerMapper::toDto)
                .toList();
    }

    @Override
    public PlayerDto findPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such player with id " + id));

        return playerMapper.toDto(player);
    }

    @Override
    public PlayerDto update(Long id, CreatePlayerRequestDto requestDto) {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such player with id " + id));

        playerMapper.updatePlayerFromDto(requestDto, player);
        return playerMapper.toDto(playerRepository.save(player));
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<PlayerDto> getPlayersByTeamId(Long teamId) {
        return playerRepository.findByTeamId(teamId)
                .stream()
                .map(playerMapper::toDto)
                .toList();
    }
}
