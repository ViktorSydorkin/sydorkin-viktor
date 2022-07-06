package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Application;

import java.util.List;

public interface ApplicationRepository {

    void addApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationById(long app_id);

    void changeApplication(long app_id, String state);

    void updateApplication(Application application);

    void deleteApplication(long app_id);

}
