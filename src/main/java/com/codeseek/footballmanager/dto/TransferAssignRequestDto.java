package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferAssignRequestDto {
    @NotNull(message = "Player ID is required")
    private Long playerId;
    private Long teamId;
}
