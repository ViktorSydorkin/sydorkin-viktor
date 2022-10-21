package com.homework5.service.implementation;

import com.homework5.entity.dto.LinerDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.mappers.LinerMapper;
import com.homework5.repository.inter.LinerRepository;
import com.homework5.service.inter.LinerService;
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
public class LinerServiceImpl implements LinerService {

    private final LinerRepository linerRepository;

    @Override
    public void saveLiner(LinerDTO linerDTO) {
        log.info("Add liner {}", linerDTO);
        try {
            if (linerDTO == null) throw new RepositoryException("Liner is null");
            linerRepository.save(LinerMapper.INSTANCE.fromDTO(linerDTO));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Override
    public LinerDTO getLinerById(long liner_id) {
        LinerDTO linerDTO;
        log.info("Get liner by id{}", liner_id);
        try {
            linerDTO = LinerMapper.INSTANCE.toDTO(linerRepository.findById(liner_id).orElseThrow(() -> new RepositoryException("Liner wasn't found")));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
        return linerDTO;
    }

    @Override
    public List<LinerDTO> getAllLiners() {
        log.info("Get all liners");
        try {
            return linerRepository.findAll().stream().map(LinerMapper.INSTANCE::toDTO).collect(Collectors.toList());
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void deleteLiner(long liner_id) {
        log.info("Liner was removed {}", liner_id);
        try {
            linerRepository.delete(linerRepository.findById(liner_id).orElseThrow(() -> new RepositoryException("Liner wasn't found")));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }
}
