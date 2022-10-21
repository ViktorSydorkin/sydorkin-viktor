package com.homework5.repository.inter;

import com.homework5.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyRepository{
    List<Company> findAll();
}
