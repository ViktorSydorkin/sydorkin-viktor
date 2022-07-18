package com.homework5.repository.inter;

import com.homework5.entity.Cruise;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends PagingAndSortingRepository<Cruise, Long> {

}
