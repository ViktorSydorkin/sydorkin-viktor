package com.homework5.repository.inter;

import com.homework5.entity.Liner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinerRepository extends JpaRepository<Liner, Long> {
}
