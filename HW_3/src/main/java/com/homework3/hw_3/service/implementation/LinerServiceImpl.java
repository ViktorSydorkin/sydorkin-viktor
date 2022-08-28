package com.homework3.hw_3.service.implementation;


import com.homework3.hw_3.entity.dto.LinerDTO;
import com.homework3.hw_3.mappers.LinerMapper;
import com.homework3.hw_3.repository.inter.LinerRepository;
import com.homework3.hw_3.service.inter.LinerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinerServiceImpl implements LinerService {

    private final LinerRepository linerRepository;

    @Override
    public void addLiner(LinerDTO linerDTO) {
        log.info("Add liner {}", linerDTO);
        linerRepository.addLiner(LinerMapper.INSTANCE.fromDTO(linerDTO));
    }

    @Override
    public LinerDTO getLinerById(long linerId) {
        log.info("Get liner bu id {}", linerId);
        return LinerMapper.INSTANCE.toDTO(linerRepository.getLinerById(linerId));
    }

    @Override
    public List<LinerDTO> getAllLiners() {
        log.info("Get all liners");
        return linerRepository.getAllLiners().stream().map(LinerMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void updateLiner(LinerDTO linerDTO) {
        log.info("Update liner {}", linerDTO);
        linerRepository.updateLiner(LinerMapper.INSTANCE.fromDTO(linerDTO));
    }

    @Override
    public synchronized void deleteLiner(long linerId) {
        log.info("Liner was removed {}", linerId);
        linerRepository.deleteLiner(linerId);
    }
}
