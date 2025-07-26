package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreateTeamRequestDto {
    @NotBlank(message = "Name must not be blank")
    private String name;
    @DecimalMin(value = "0.00", message = "Commission must be in range 0.00 - 0.1")
    @DecimalMax(value = "0.10", message = "Commission must be in range 0.00 - 0.1")
    @NotNull(message = "Commission is required")
    private BigDecimal commission;
    @NotNull(message = "Balance is required")
    private BigDecimal balance;
}
