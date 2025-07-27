package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferMoveRequestDto {
    @NotNull(message = "Player ID is required")
    private Long playerId;

    @NotNull(message = "Buyer Team ID is required")
    private Long buyerTeamId;

    @NotNull(message = "Seller Team ID is required")
    private Long sellerTeamId;
}
