package com.codeseek.footballmanager.mapper;

import com.codeseek.footballmanager.dto.CreateTeamRequestDto;
import com.codeseek.footballmanager.dto.TeamDto;
import com.codeseek.footballmanager.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {
    TeamDto toDto(Team team);

    Team toModel(CreateTeamRequestDto requestDto);

    void updateTeamFromDto(CreateTeamRequestDto team, @MappingTarget Team entity);
}
