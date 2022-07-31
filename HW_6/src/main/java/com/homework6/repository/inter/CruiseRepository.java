package com.homework6.repository.inter;

import com.homework6.entity.Cruise;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends PagingAndSortingRepository<Cruise, Long> {

}
