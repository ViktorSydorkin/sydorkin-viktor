package com.homework4.hw_4.service.inter;


import com.homework4.hw_4.entity.dto.RouteDTO;

import java.util.List;

public interface RouteService {
    List<RouteDTO> getAllRoutes(/*long lang_id*/);
}
