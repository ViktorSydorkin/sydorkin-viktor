package com.homework3.hw_3.mappers;

import com.homework3.hw_3.entity.Route;
import com.homework3.hw_3.entity.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDTO toDTO(Route route);

    Route fromDTO(RouteDTO routeDTO);
}
