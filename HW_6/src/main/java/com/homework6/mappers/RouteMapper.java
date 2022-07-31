package com.homework6.mappers;

import com.homework6.entity.Route;
import com.homework6.entity.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {

    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDTO toDTO(Route route);

    Route fromDTO(RouteDTO routeDTO);

}
