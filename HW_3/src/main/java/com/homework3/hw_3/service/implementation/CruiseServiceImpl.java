package com.homework3.hw_3.service.implementation;

import com.homework3.hw_3.entity.dto.CruiseDTO;
import com.homework3.hw_3.mappers.CruiseMapper;
import com.homework3.hw_3.repository.inter.CruiseRepository;
import com.homework3.hw_3.service.inter.CruiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CruiseServiceImpl implements CruiseService {

    private final CruiseRepository cruiseRepository;

    @Override
    public List<CruiseDTO> getAllCruise() {
        log.info("Get all cruises");
        return cruiseRepository.getAllCruise().stream().map(CruiseMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void changeAvailability(long cruise_id) {
        log.info("Changed availability {}", cruise_id);
        cruiseRepository.changeAvailability(cruise_id);
    }

    @Override
    public void addCruise(CruiseDTO cruiseDTO) {
        log.info("Add cruise {}", cruiseDTO);
        System.out.println(cruiseDTO + "was added");
        cruiseRepository.addCruise(CruiseMapper.INSTANCE.fromDTO(cruiseDTO));
    }

    @Override
    public CruiseDTO getCruiseById(long cruise_id) {
        log.info("Get cruise by id {}", cruise_id);
        return CruiseMapper.INSTANCE.toDTO(cruiseRepository.getCruiseById(cruise_id));
    }

    @Override
    public synchronized void updateCruise(CruiseDTO cruiseDTO) {
        log.info("Cruise was updated {}", cruiseDTO);
        System.out.println("Cruise " + cruiseDTO + "was updated");
        cruiseRepository.updateCruise(CruiseMapper.INSTANCE.fromDTO(cruiseDTO));
    }

    @Override
    public synchronized void deleteCruise(long cruise_id) {
        log.info("Cruise was removed {}", cruise_id);
        System.out.println("Cruise " + cruise_id + "was removed");
    }
}
