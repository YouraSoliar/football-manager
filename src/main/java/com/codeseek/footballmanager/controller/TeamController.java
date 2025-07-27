package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.CreateTeamRequestDto;
import com.codeseek.footballmanager.dto.TeamDto;
import com.codeseek.footballmanager.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAll() {
        List<TeamDto> teams = teamService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
        TeamDto teamDto = teamService.findTeamById(id);
        return new ResponseEntity<>(teamDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@Valid @RequestBody CreateTeamRequestDto requestDto) {
        TeamDto teamDto = teamService.save(requestDto);
        return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @Valid @RequestBody CreateTeamRequestDto requestDto) {
        TeamDto updatedTeam = teamService.update(id, requestDto);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Long id) {
        teamService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
