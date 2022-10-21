package com.homework5.repository.inter;

import com.homework5.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Long> {
}
