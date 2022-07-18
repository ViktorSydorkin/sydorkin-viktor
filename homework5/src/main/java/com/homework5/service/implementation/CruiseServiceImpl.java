package com.homework5.service.implementation;

import com.homework5.entity.Cruise;
import com.homework5.entity.dto.CruiseDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.mappers.CruiseMapper;
import com.homework5.repository.inter.CruiseRepository;
import com.homework5.service.inter.CruiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CruiseServiceImpl implements CruiseService {

    private final CruiseRepository cruiseRepository;

    @Override
    public List<CruiseDTO> getAllCruise() {
        log.info("Get all cruises");
        Pageable pageable = PageRequest.of(0, 6, Sort.by("title"));
        return cruiseRepository.findAll(pageable).stream().map(CruiseMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void changeAvailability(long cruise_id) {
        log.info("Changed availability {}", cruise_id);
        Cruise cruise;
        try {
            cruise = cruiseRepository.findById(cruise_id).orElseThrow(() -> new RepositoryException("Cruise wasn't found"));
            cruise.setAvailable(cruise.getAvailable() - 1);
            cruiseRepository.save(cruise);
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Override
    public void saveCruise(CruiseDTO cruiseDTO) {
        log.info("Add cruise {}", cruiseDTO);
        cruiseRepository.save(CruiseMapper.INSTANCE.fromDTO(cruiseDTO));
    }

    @Override
    public CruiseDTO getCruiseById(long cruise_id) {
        log.info("Get cruise by id {}", cruise_id);
        return CruiseMapper.INSTANCE.toDTO(cruiseRepository.findById(cruise_id).orElseThrow(() -> new RepositoryException("")));
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void deleteCruise(long cruise_id) {
        log.info("Cruise was removed {}", cruise_id);
        cruiseRepository.delete(cruiseRepository.findById(cruise_id).orElseThrow(() -> new RepositoryException("")));
    }
}
