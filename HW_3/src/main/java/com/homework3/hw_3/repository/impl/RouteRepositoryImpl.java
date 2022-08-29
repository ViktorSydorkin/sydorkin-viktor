package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Route;
import com.homework3.hw_3.repository.inter.RouteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteRepositoryImpl implements RouteRepository {
    @Override
    public List<Route> getAllRoutes() {
        return null;
    }
}
