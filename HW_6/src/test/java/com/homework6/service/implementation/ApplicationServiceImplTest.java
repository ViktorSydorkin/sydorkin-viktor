package com.homework6.service.implementation;

import com.homework6.entity.Application;
import com.homework6.entity.Liner;
import com.homework6.entity.User;
import com.homework6.entity.enums.Paid;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.ApplicationMapper;
import com.homework6.mappers.UserMapper;
import com.homework6.repository.inter.ApplicationRepository;
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
class ApplicationServiceImplTest {
    @Mock
    ApplicationRepository applicationRepository;

    @InjectMocks
    ApplicationServiceImpl applicationService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;

    private final static Paid MOCK_PAID = Paid.PAID;

    private final static String MOCK_STATE = "PAID";

    @Test
    void saveApplication() {
        Application expected = Application.builder().id(MOCKED_ID1).build();
        when(applicationRepository.save(expected)).thenReturn(expected);

        applicationService.saveApplication(ApplicationMapper.INSTANCE.toDTO(expected));

        verify(applicationRepository, times(1)).save(expected);
    }

    @Test
    void getAllApplications() {
        Application expected1 = Application.builder().id(MOCKED_ID1).build();
        Application expected2 = Application.builder().id(MOCKED_ID2).build();
        List<Application> expected = List.of(expected1, expected2);
        when(applicationRepository.findAll()).thenReturn(expected);

        assertThat(applicationService.getAllApplications(), hasSize(2));
    }

    @Test
    void getApplicationById() {
        Application expected1 = Application.builder().id(MOCKED_ID1).build();
        when(applicationRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(expected1));

        assertEquals(expected1, ApplicationMapper.INSTANCE.fromDTO(applicationService.getApplicationById(MOCKED_ID1)));
    }

    @Test
    void changeApplication() {
        Application expected = Application.builder().id(MOCKED_ID1).paid(MOCK_PAID).build();
        when(applicationRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(expected));
        when(applicationRepository.save(expected)).thenReturn(expected);

        applicationService.changeApplication(MOCKED_ID1, MOCK_STATE);

        verify(applicationRepository, times(1)).save(expected);
    }

    @Test
    void deleteApplication() {
        Application expected1 = Application.builder().id(MOCKED_ID1).build();
        when(applicationRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(expected1));
        doNothing().when(applicationRepository).delete(expected1);

        applicationService.deleteApplication(MOCKED_ID1);

        verify(applicationRepository, times(1)).delete(expected1);
    }
    @Test
    void deleteApplicationThrow() {
        Application expected1 = Application.builder().id(MOCKED_ID1).build();
        //doThrow(RepositoryException.class).when(applicationRepository).delete(expected1);

        assertThrows(ServiceException.class, () -> applicationService.deleteApplication(MOCKED_ID1));
    }
}