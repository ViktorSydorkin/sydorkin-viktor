package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Application;

import java.util.List;

public interface ApplicationRepository {
    void addApplication(Application application);

    List<Application> getAllApplications(/*long lang_id*/);

    //List<Application> getApplicationsForUser(long lang_id, long user_id);

    Application getApplicationById(/*long lang_id,*/ long app_id);

    void changeApplication(long app_id, String state);


/*    boolean approveApplication(long lang_id, long app_id);

    boolean openApplication(long lang_id, long app_id);

    boolean endApplication(long lang_id, long app_id);

    boolean payApplication(long lang_id, long app_id);*/

    void updateApplication(Application application);

    void deleteApplication(long app_id);
}
