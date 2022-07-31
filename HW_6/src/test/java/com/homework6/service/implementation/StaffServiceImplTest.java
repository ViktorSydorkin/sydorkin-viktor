package com.homework6.service.implementation;

import com.homework6.entity.Staff;
import com.homework6.entity.User;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.StaffMapper;
import com.homework6.repository.inter.StaffRepository;
import com.homework6.repository.inter.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StaffServiceImplTest {

    @Mock
    private StaffRepository staffRepository;

    @InjectMocks
    private StaffServiceImpl staffService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;

    @Test
    void getAllStaff() {
        Staff staff1 = Staff.builder().id(MOCKED_ID1).build();
        Staff staff2 = Staff.builder().id(MOCKED_ID2).build();
        List<Staff> expected = List.of(staff1, staff2);

        when(staffRepository.findAll()).thenReturn(expected);

        assertThat(staffService.getAllStaff(), hasSize(2));
    }

    @Test
    void saveStaff() {
        Staff staff1 = Staff.builder().id(MOCKED_ID1).build();
        when(staffRepository.save(staff1)).thenReturn(staff1);

        staffService.saveStaff(StaffMapper.INSTANCE.toDTO(staff1));

        verify(staffRepository, times(1)).save(staff1);
    }

    @Test
    void deleteStaff() {
        Staff staff1 = Staff.builder().id(MOCKED_ID1).build();
        when(staffRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(staff1));
        doNothing().when(staffRepository).delete(staff1);

        staffService.deleteStaff(MOCKED_ID1);

        verify(staffRepository, times(1)).delete(staff1);

    }  @Test
    void deleteStaffThrow() {
        Staff staff1 = Staff.builder().id(MOCKED_ID1).build();
        //doThrow(RepositoryException.class).when(staffRepository).delete(staff1);

        assertThrows(ServiceException.class, () -> staffService.deleteStaff(MOCKED_ID1));
    }
}