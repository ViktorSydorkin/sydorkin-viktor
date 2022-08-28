package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Application;
import com.homework3.hw_3.repository.inter.ApplicationRepository;
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
    public Application getApplicationById(long appId) {
        return null;
    }

    @Override
    public void changeApplication(long appId, String state) {
    }

    @Override
    public void updateApplication(Application application) {
    }

    @Override
    public void deleteApplication(long appId) {
    }
}
