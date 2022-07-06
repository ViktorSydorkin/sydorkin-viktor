package com.homework4.hw_4.repository.impl;

import com.homework4.hw_4.entity.Application;
import com.homework4.hw_4.repository.inter.ApplicationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Override
    public void addApplication(Application application) {
    }

    @Override
    public List<Application> getAllApplications() {
        return null;
    }

    @Override
    public Application getApplicationById(long app_id) {
        return null;
    }

    @Override
    public void changeApplication(long app_id, String state) {
    }

    @Override
    public void updateApplication(Application application) {
    }

    @Override
    public void deleteApplication(long app_id) {
    }
}
