package com.homework6.repository.inter;

import com.homework6.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Long> {
}
