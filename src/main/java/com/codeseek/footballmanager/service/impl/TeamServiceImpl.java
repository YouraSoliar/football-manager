package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.repository.TeamRepository;
import com.codeseek.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
}
