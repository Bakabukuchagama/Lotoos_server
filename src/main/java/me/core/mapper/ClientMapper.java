package me.core.mapper;

import me.core.dto.ClientDto;
import me.core.entity.Client;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientDto dto);

    //@Mapping(target = "id", ignore = true)
    ClientDto toDto(Client dto);
}
