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
    public synchronized void changeAvailability(long cruiseId) {
        log.info("Changed availability {}", cruiseId);
        cruiseRepository.changeAvailability(cruiseId);
    }

    @Override
    public void addCruise(CruiseDTO cruiseDTO) {
        log.info("Add cruise {}", cruiseDTO);
        cruiseRepository.addCruise(CruiseMapper.INSTANCE.fromDTO(cruiseDTO));
    }

    @Override

    public CruiseDTO getCruiseById(long cruiseId) {
        log.info("Get cruise by id {}", cruiseId);
        return CruiseMapper.INSTANCE.toDTO(cruiseRepository.getCruiseById(cruiseId));
    }

    @Override
    public synchronized void updateCruise(CruiseDTO cruiseDTO) {
        log.info("Cruise was updated {}", cruiseDTO);
        cruiseRepository.updateCruise(CruiseMapper.INSTANCE.fromDTO(cruiseDTO));
    }

    @Override
    public synchronized void deleteCruise(long cruiseId) {
        log.info("Cruise was removed {}", cruiseId);
        cruiseRepository.deleteCruise(cruiseId);
    }
}
