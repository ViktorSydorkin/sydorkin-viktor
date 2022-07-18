package com.homework5.service.implementation;

import com.homework5.entity.dto.StaffDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.entity.exception.ServiceException;
import com.homework5.mappers.StaffMapper;
import com.homework5.repository.inter.StaffRepository;
import com.homework5.service.inter.StaffService;
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
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public List<StaffDTO> getAllStaff() {
        log.info("Get all staff");
        return staffRepository.findAll().stream().map(StaffMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void saveStaff(StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        try {
            if (staffDTO == null) throw new RepositoryException("Staff is null");
            staffRepository.save(StaffMapper.INSTANCE.fromDTO(staffDTO));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new ServiceException(r.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public synchronized void deleteStaff(long id) {
        log.info("Staff was removed {}", id);
        try {
            staffRepository.delete(staffRepository.findById(id).orElseThrow(() -> new RepositoryException("Staff wasn't found")));
        } catch (RepositoryException r) {
            log.error("Repository has thrown an exception { }", r);
            throw new RepositoryException(r.getMessage());
        }
    }
}
