package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
}
