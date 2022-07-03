package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.Route;
import com.homework3.hw_3.entity.dto.RouteDTO;

import java.util.List;

public interface RouteRepository {
    List<Route> getAllRoutes(/*long lang_id*/);
}
