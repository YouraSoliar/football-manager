package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.exception.EntityNotFoundException;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.service.InternalPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternalPlayerServiceImpl implements InternalPlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player getEntityById(Long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such player with id " + id));
    }

    @Override
    public Player saveEntity(Player player) {
        return playerRepository.save(player);
    }
}
