package com.homework3.hw_3.service.inter;


import com.homework3.hw_3.entity.Application;
import com.homework3.hw_3.entity.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    void addApplication(ApplicationDTO applicationDTO);

    List<ApplicationDTO> getAllApplications(/*long lang_id*/);

    //List<Application> getApplicationsForUser(long lang_id, long user_id);

    ApplicationDTO getApplicationById(/*long lang_id,*/ long app_id);
    void changeApplication(long app_id, String state);


/*    boolean approveApplication(long lang_id, long app_id);

    boolean openApplication(long lang_id, long app_id);

    boolean endApplication(long lang_id, long app_id);

    boolean payApplication(long lang_id, long app_id);*/

    void updateApplication(ApplicationDTO applicationDTO);

    void deleteApplication(long app_id);
}
