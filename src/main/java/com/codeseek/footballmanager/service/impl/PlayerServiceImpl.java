package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
}
