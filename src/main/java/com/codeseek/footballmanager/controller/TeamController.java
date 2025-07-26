package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.CreateTeamRequestDto;
import com.codeseek.footballmanager.dto.TeamDto;
import com.codeseek.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<TeamDto> getAll() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto createTeam(@RequestBody CreateTeamRequestDto requestDto) {
        return teamService.save(requestDto);
    }

    @PutMapping("/{id}")
    public TeamDto updateTeam(@PathVariable Long id, @RequestBody CreateTeamRequestDto requestDto) {
        return teamService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeamById(@PathVariable Long id) {
        teamService.deleteById(id);
    }
}
