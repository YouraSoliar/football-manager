package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TeamDto {
    @NotNull
    private Long id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotNull(message = "Commission is required")
    private BigDecimal commission;
    @NotNull(message = "Balance is required")
    private BigDecimal balance;
}
