package com.homework3.hw_3.service.implementation;


import com.homework3.hw_3.entity.dto.StaffDTO;
import com.homework3.hw_3.mappers.StaffMapper;
import com.homework3.hw_3.repository.inter.StaffRepository;
import com.homework3.hw_3.service.inter.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public List<StaffDTO> getAllStaff() {
        log.info("Get all staff");
        return staffRepository.getAllStaff().stream().map(StaffMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void addStaff(StaffDTO staffDTO) {
        log.info("Add staff {}", staffDTO);
        staffRepository.addStaff(StaffMapper.INSTANCE.fromDTO(staffDTO));
    }

    @Override
    public synchronized void updateStaff(StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        staffRepository.updateStaff(StaffMapper.INSTANCE.fromDTO(staffDTO));
    }

    @Override
    public synchronized void deleteStaff(long id) {
        log.info("Staff was removed {}", id);
        staffRepository.deleteStaff(id);
    }
}
