package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerDto {
    @NotNull
    private Long id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotNull(message = "Experience months is required")
    private int monthsExperience;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Player must be at least 18 years old")
    private int age;
    private Long teamId;
}
