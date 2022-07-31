package com.homework6.repository.inter;

import com.homework6.entity.Company;

import java.util.List;

public interface CompanyRepository{
    List<Company> findAll();
}
