package com.homework5.service.implementation;


import com.homework5.entity.dto.ApplicationDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.mappers.ApplicationMapper;
import com.homework5.repository.inter.ApplicationRepository;
import com.homework5.service.inter.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public void saveApplication(ApplicationDTO applicationDTO) {
        log.info("Add application {}", applicationDTO);
        System.out.println("Application " + applicationDTO + "was added");
        applicationRepository.save(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
    }


    @Override
    public List<ApplicationDTO> getAllApplications() {
        log.info("Get all applications");
        return applicationRepository.findAll().stream().map(ApplicationMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


    @Override
    public ApplicationDTO getApplicationById(long app_id) {
        log.info("Get application by id {}", app_id);
        return ApplicationMapper.INSTANCE.toDTO(applicationRepository.findById(app_id).orElseThrow(() -> new RepositoryException("")));
    }

    @Transactional
    @Override
    public void changeApplication(long app_id, String state) {

        log.info("Changed application's state to {}", state);
    }

    @Override
    public synchronized void deleteApplication(long app_id) {
        log.info("Application was removed {}", app_id);
        applicationRepository.delete(applicationRepository.findById(app_id).orElseThrow(() -> new RepositoryException("")));
    }
}
