package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Application;
import com.homework3.hw_3.repository.inter.ApplicationRepository;

import java.util.List;

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
