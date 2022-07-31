package com.homework6.service.implementation;

import com.homework6.entity.dto.ApplicationDTO;
import com.homework6.entity.enums.Approved;
import com.homework6.entity.enums.Closed;
import com.homework6.entity.enums.Ended;
import com.homework6.entity.enums.Paid;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.ApplicationMapper;
import com.homework6.repository.inter.ApplicationRepository;
import com.homework6.service.inter.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public void saveApplication(ApplicationDTO applicationDTO) {
        log.info("Add application {}", applicationDTO);
        try {
            if (applicationDTO == null) throw new RepositoryException("Application is null");
            applicationRepository.save(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
        } catch (RepositoryException r) {
            throw new ServiceException(r.getMessage());
        }
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        log.info("Get all applications");
        try {
            return applicationRepository.findAll().stream().map(ApplicationMapper.INSTANCE::toDTO).collect(Collectors.toList());
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Override
    public ApplicationDTO getApplicationById(long app_id) {
        log.info("Get application by id {}", app_id);
        ApplicationDTO applicationDTO;
        try {
            applicationDTO = ApplicationMapper.INSTANCE.toDTO(applicationRepository.findById(app_id).orElseThrow(() -> new RepositoryException("Application wasn't found")));
        } catch (RepositoryException r) {
            throw new ServiceException(r.getMessage());
        }
        return applicationDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public void changeApplication(long app_id, String state) {
        log.info("Changed application's state to {}", state);
        ApplicationDTO applicationDTO;
        try {
            applicationDTO = changeState(ApplicationMapper.INSTANCE.toDTO(applicationRepository.findById(app_id).orElseThrow(() -> new RepositoryException("Application wasn't found"))), state);
            applicationRepository.save(ApplicationMapper.INSTANCE.fromDTO(applicationDTO));
        } catch (RepositoryException r) {
            throw new ServiceException(r.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void deleteApplication(long app_id) {
        log.info("Application was removed {}", app_id);
        try {
            applicationRepository.delete(applicationRepository.findById(app_id).orElseThrow(() -> new RepositoryException("Application wasn't found")));
        } catch (RepositoryException r) {
            throw new ServiceException(r.getMessage());
        }
    }

    private ApplicationDTO changeState(ApplicationDTO applicationDTO, String state) {
        if (state.equalsIgnoreCase(Approved.APPROVED.name())) {
            applicationDTO.setApproved(Approved.APPROVED);
        } else if (state.equalsIgnoreCase(Approved.DISAPPROVED.name())) {
            applicationDTO.setApproved(Approved.DISAPPROVED);
        } else if (state.equalsIgnoreCase(Closed.CLOSED.name())) {
            applicationDTO.setClosed(Closed.CLOSED);
        } else if (state.equalsIgnoreCase(Closed.OPENED.name())) {
            applicationDTO.setClosed(Closed.OPENED);
        } else if (state.equalsIgnoreCase(Ended.ENDED.name())) {
            applicationDTO.setEnded(Ended.ENDED);
        } else if (state.equalsIgnoreCase(Ended.STARTED.name())) {
            applicationDTO.setEnded(Ended.STARTED);
        } else if (state.equalsIgnoreCase(Paid.PAID.name())) {
            applicationDTO.setPaid(Paid.PAID);
        } else if (state.equalsIgnoreCase(Paid.UNPAID.name())) {
            applicationDTO.setPaid(Paid.UNPAID);
        }
        return applicationDTO;
    }
}
