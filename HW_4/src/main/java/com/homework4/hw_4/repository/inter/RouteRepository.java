package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Route;

import java.util.List;

public interface RouteRepository {
    List<Route> getAllRoutes(/*long lang_id*/);
}
