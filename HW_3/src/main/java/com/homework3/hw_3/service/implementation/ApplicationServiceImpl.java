package com.homework3.hw_3.service.implementation;


import com.homework3.hw_3.entity.dto.ApplicationDTO;
import com.homework3.hw_3.mappers.ApplicationMapper;
import com.homework3.hw_3.repository.inter.ApplicationRepository;
import com.homework3.hw_3.service.inter.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public void addApplication(ApplicationDTO applicationDTO) {
        log.info("Add application {}", applicationDTO);
        System.out.println("Application " + applicationDTO + "was added");
        applicationRepository.addApplication(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        log.info("Get all applications");
        return applicationRepository.getAllApplications().stream().map(ApplicationMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ApplicationDTO getApplicationById(long app_id) {
        log.info("Get application by id {}", app_id);
        return ApplicationMapper.INSTANCE.toDTO(applicationRepository.getApplicationById(app_id));
    }

    @Override
    public void changeApplication(long app_id, String state) {
        log.info("Changed application's state to {}", state);
    }

    @Override
    public void updateApplication(ApplicationDTO applicationDTO) {
        log.info("AUpdated application {}", applicationDTO);
        System.out.println("Application " + applicationDTO + " was updated");
        applicationRepository.updateApplication(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
    }

    @Override
    public synchronized void deleteApplication(long app_id) {
        log.info("Application was removed {}", app_id);
        System.out.println("Application " + app_id + " was removed");
    }
}
