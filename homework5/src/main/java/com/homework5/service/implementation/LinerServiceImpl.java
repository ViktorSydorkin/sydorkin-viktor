package com.homework5.service.implementation;


import com.homework5.entity.dto.LinerDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.mappers.LinerMapper;
import com.homework5.repository.inter.LinerRepository;
import com.homework5.service.inter.LinerService;
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
    public void saveLiner(LinerDTO linerDTO) {
        log.info("Add liner {}", linerDTO);
        System.out.println("Liner " + linerDTO + " was added");
        linerRepository.save( LinerMapper.INSTANCE.fromDTO(linerDTO));
    }

    @Override
    public LinerDTO getLinerById(long liner_id) {
        log.info("Get liner bu id {}", liner_id);
        return LinerMapper.INSTANCE.toDTO(linerRepository.findById(liner_id).orElseThrow(()-> new RepositoryException("")));
    }

    @Override
    public List<LinerDTO> getAllLiners() {
        log.info("Get all liners");
        return linerRepository.findAll().stream().map(LinerMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void deleteLiner(long liner_id) {
        log.info("Liner was removed {}", liner_id);
       linerRepository.delete(linerRepository.findById(liner_id).orElseThrow(()-> new RepositoryException("")));
    }
}
