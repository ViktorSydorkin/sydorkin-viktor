package com.homework5.repository.impl;

import com.homework5.entity.Company;
import com.homework5.repository.inter.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Company> findAll() {
       return jdbcTemplate.queryForList("select * from company", Company.class);
    }
}
