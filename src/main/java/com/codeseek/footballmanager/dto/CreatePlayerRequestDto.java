package com.codeseek.footballmanager.dto;

import jakarta.validation.constraints.NotNull;

public class CreatePlayerRequestDto {
    @NotNull
    private String name;
    @NotNull
    private int monthsExperience;
    @NotNull
    private int age;
    private Long teamId;
}
