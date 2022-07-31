package com.homework6.service.inter;

import com.homework6.entity.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

    void saveApplication(ApplicationDTO applicationDTO);

    List<ApplicationDTO> getAllApplications();

    ApplicationDTO getApplicationById(long app_id);

    void changeApplication(long app_id, String state);

    void deleteApplication(long app_id);

}
