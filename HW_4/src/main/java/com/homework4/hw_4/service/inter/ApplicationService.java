package com.homework4.hw_4.service.inter;

import com.homework4.hw_4.entity.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

    void addApplication(ApplicationDTO applicationDTO);

    List<ApplicationDTO> getAllApplications();

    ApplicationDTO getApplicationById(long app_id);

    void changeApplication(long app_id, String state);

    void updateApplication(ApplicationDTO applicationDTO);

    void deleteApplication(long app_id);

}
