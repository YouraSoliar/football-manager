package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlayerDto {
    @NotNull
    private Long id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotNull(message = "Experience months is required")
    private int monthsExperience;
    @NotNull(message = "Age is required")
    private int age;
    private Long teamId;
}
