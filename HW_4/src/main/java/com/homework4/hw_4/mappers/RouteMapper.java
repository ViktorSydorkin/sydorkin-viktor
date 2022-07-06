package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.Route;
import com.homework4.hw_4.entity.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDTO toDTO(Route route);

    Route fromDTO(RouteDTO routeDTO);

}
