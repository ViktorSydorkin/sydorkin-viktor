package com.homework4.hw_4.service.implementation;


import com.homework4.hw_4.entity.dto.StaffDTO;
import com.homework4.hw_4.mappers.StaffMapper;
import com.homework4.hw_4.repository.inter.StaffRepository;
import com.homework4.hw_4.service.inter.StaffService;
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
        System.out.println("Staff " + staffDTO + " was added");
        staffRepository.addStaff(StaffMapper.INSTANCE.fromDTO(staffDTO));
    }

    @Override
    public synchronized void updateStaff(StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        System.out.println("Staff " + staffDTO + " was updated");
        staffRepository.updateStaff(StaffMapper.INSTANCE.fromDTO(staffDTO));
    }

    @Override
    public synchronized void deleteStaff(long id) {
        log.info("Staff was removed {}", id);
        System.out.println("Staff " + id + " was removed");
    }
}
