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
        System.out.println("Liner " + linerDTO + " was added");
        linerRepository.addLiner(LinerMapper.INSTANCE.fromDTO(linerDTO));
    }

    @Override
    public LinerDTO getLinerById(long liner_id) {
        log.info("Get liner bu id {}", liner_id);
        return LinerMapper.INSTANCE.toDTO(linerRepository.getLinerById(liner_id));
    }

    @Override
    public List<LinerDTO> getAllLiners() {
        log.info("Get all liners");
        return linerRepository.getAllLiners().stream().map(LinerMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void updateLiner(LinerDTO linerDTO) {

        log.info("Update liner {}", linerDTO);
        System.out.println("Liner " + linerDTO + " was updated");
        linerRepository.updateLiner(LinerMapper.INSTANCE.fromDTO(linerDTO));
    }

    @Override
    public synchronized void deleteLiner(long liner_id) {
        log.info("Liner was removed {}", liner_id);
        System.out.println("Liner " + liner_id + "was removed");
    }
}
