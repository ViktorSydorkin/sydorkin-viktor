package com.homework5.service.implementation;


import com.homework5.entity.dto.StaffDTO;
import com.homework5.entity.exception.RepositoryException;
import com.homework5.mappers.StaffMapper;
import com.homework5.repository.inter.StaffRepository;
import com.homework5.service.inter.StaffService;
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
        return staffRepository.findAll().stream().map(StaffMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public synchronized void saveStaff(StaffDTO staffDTO) {
        log.info("Update staff {}", staffDTO);
        System.out.println("Staff " + staffDTO + " was updated");
        staffRepository.save(StaffMapper.INSTANCE.fromDTO(staffDTO));
    }

    @Override
    public synchronized void deleteStaff(long id) {
        log.info("Staff was removed {}", id);
      staffRepository.delete(staffRepository.findById(id).orElseThrow(()-> new RepositoryException("")));
    }
}
