package com.homework6.repository.inter;

import com.homework6.entity.Liner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinerRepository extends JpaRepository<Liner, Long> {
}
