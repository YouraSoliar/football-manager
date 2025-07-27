package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.TransferAssignRequestDto;
import com.codeseek.footballmanager.dto.TransferMoveRequestDto;

public interface TransferService {
    void transferPlayer(TransferMoveRequestDto requestDto);
    void updatePlayerTeamAssignment(TransferAssignRequestDto requestDto);
}
