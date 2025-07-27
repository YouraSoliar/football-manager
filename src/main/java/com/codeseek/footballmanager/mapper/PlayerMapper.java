package com.codeseek.footballmanager.mapper;

import com.codeseek.footballmanager.config.MapperConfig;
import com.codeseek.footballmanager.dto.CreatePlayerRequestDto;
import com.codeseek.footballmanager.dto.PlayerDto;
import com.codeseek.footballmanager.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface PlayerMapper {
    @Mapping(source = "team.id", target = "teamId")
    PlayerDto toDto(Player player);

    Player toModel(CreatePlayerRequestDto requestDto);

    void updatePlayerFromDto(CreatePlayerRequestDto player, @MappingTarget Player entity);
}
