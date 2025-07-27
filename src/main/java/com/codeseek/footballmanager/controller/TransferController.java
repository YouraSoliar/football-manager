package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.TransferAssignRequestDto;
import com.codeseek.footballmanager.dto.TransferMoveRequestDto;
import com.codeseek.footballmanager.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfers")
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/move")
    public ResponseEntity<Void> transferPlayer(@RequestBody @Valid TransferMoveRequestDto request) {
        transferService.transferPlayer(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> updatePlayerTeamAssignment(@RequestBody @Valid TransferAssignRequestDto request) {
        transferService.updatePlayerTeamAssignment(request);
        return ResponseEntity.ok().build();
    }
}
