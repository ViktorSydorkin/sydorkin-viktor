package com.homework5.repository.inter;

import com.homework5.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository  extends JpaRepository<Route, Long> {
}
