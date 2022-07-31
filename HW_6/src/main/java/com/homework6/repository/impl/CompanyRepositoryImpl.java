package com.homework6.repository.impl;

import com.homework6.entity.Company;
import com.homework6.repository.inter.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Company> findAll() {
       return jdbcTemplate.queryForList("select * from company", Company.class);
    }
}
