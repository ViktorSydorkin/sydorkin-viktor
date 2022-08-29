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
        applicationRepository.addApplication(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        log.info("Get all applications");
        return applicationRepository.getAllApplications().stream().map(ApplicationMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ApplicationDTO getApplicationById(long appId) {
        log.info("Get application by id {}", appId);
        return ApplicationMapper.INSTANCE.toDTO(applicationRepository.getApplicationById(appId));
    }

    @Override
    public void changeApplication(long appId, String state) {
        log.info("Changed application's state to {}", state);
        applicationRepository.changeApplication(appId, state);
    }

    @Override
    public void updateApplication(ApplicationDTO applicationDTO) {
        log.info("AUpdated application {}", applicationDTO);
        applicationRepository.updateApplication(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
    }

    @Override
    public synchronized void deleteApplication(long appId) {
        log.info("Application was removed {}", appId);
        applicationRepository.deleteApplication(appId);
    }
}
