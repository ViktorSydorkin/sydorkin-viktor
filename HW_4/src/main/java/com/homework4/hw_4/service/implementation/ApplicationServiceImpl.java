package com.homework4.hw_4.service.implementation;


import com.homework4.hw_4.entity.dto.ApplicationDTO;
import com.homework4.hw_4.mappers.ApplicationMapper;
import com.homework4.hw_4.repository.inter.ApplicationRepository;
import com.homework4.hw_4.service.inter.ApplicationService;
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
    public List<ApplicationDTO> getAllApplications(/*long lang_id*/) {
        log.info("Get all applications");
        return applicationRepository.getAllApplications().stream().map(ApplicationMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }


    @Override
    public ApplicationDTO getApplicationById(/*long lang_id,*/ long app_id) {
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

    /**
     * Ends the application when the cruise became ended
     *
     * @param cruise_id - id of cruise the was ended
     * @param app_id    - id of application to be ended
     */
   /* public void scheduledCloser(long cruise_id, long app_id) {
        CruiseServiceImpl cruiseServiceImpl = new CruiseServiceImpl();
        Cruise cruise = cruiseServiceImpl.getCruiseById(1, cruise_id);
        LocalDateTime end = cruise.getEnd().toLocalDateTime();
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        long minutes = ChronoUnit.MINUTES.between(now, end);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new CloserTask(app_id), minutes, TimeUnit.MINUTES);
    }

    *//**
     * Starts a thread the counts the time before ending the application
     *//*
    private static class CloserTask implements Runnable {
        long id;

        public CloserTask(long id) {
            this.id = id;
        }

        @Override
        public void run() {
            ApplicationServiceImpl applicationServiceImpl = new ApplicationServiceImpl();
            applicationServiceImpl.endApplication(1, id);
        }
    }*/
}
