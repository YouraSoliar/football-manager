package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateTeamRequestDto {
    @NotNull
    private String name;
    @DecimalMin("0.00")
    @DecimalMax("0.10")
    @NotNull
    private BigDecimal commission;
    @NotNull
    private BigDecimal balance;
}
