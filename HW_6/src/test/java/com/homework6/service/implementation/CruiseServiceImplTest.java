package com.homework6.service.implementation;

import com.homework6.entity.Application;
import com.homework6.entity.Cruise;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.ApplicationMapper;
import com.homework6.mappers.CruiseMapper;
import com.homework6.repository.inter.CruiseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CruiseServiceImplTest {

    @Mock
    CruiseRepository cruiseRepository;

    @InjectMocks
    CruiseServiceImpl cruiseService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;
    private final static int MOCKED_AVAILABLE = 10;
    private final static Pageable PAGEABLE_MOCK = PageRequest.of(0, 6, Sort.by("title"));

    @Test
    void getAllCruise() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).build();
        Cruise cruise2 = Cruise.builder().id(MOCKED_ID2).build();
        Page<Cruise>  expected = new PageImpl<>(List.of(cruise1, cruise2));
        when(cruiseRepository.findAll(PAGEABLE_MOCK)).thenReturn(expected);//           .thenReturn(expected);

        assertThat(cruiseService.getAllCruise(), hasSize(2));
    }

    @Test
    void changeAvailability() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).available(MOCKED_AVAILABLE).build();
        when(cruiseRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(cruise1));
        when(cruiseRepository.save(cruise1)).thenReturn(cruise1);

        cruiseService.changeAvailability(MOCKED_ID1);

        verify(cruiseRepository, times(1)).save(cruise1);
    }

    @Test
    void saveCruise() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).build();
        when(cruiseRepository.save(cruise1)).thenReturn(cruise1);

        cruiseService.saveCruise(CruiseMapper.INSTANCE.toDTO(cruise1));

        verify(cruiseRepository, times(1)).save(cruise1);
    }

    @Test
    void getCruiseById() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).build();
        when(cruiseRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(cruise1));

        assertEquals(cruise1, CruiseMapper.INSTANCE.fromDTO(cruiseService.getCruiseById(MOCKED_ID1)));
    }

    @Test
    void deleteCruise() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).build();
        when(cruiseRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(cruise1));
        doNothing().when(cruiseRepository).delete(cruise1);

        cruiseService.deleteCruise(MOCKED_ID1);

        verify(cruiseRepository, times(1)).delete(cruise1);
    }
    @Test
    void deleteCruiseThrow() {
        Cruise cruise1 = Cruise.builder().id(MOCKED_ID1).build();
        //doThrow(RepositoryException.class).when(cruiseRepository).delete(cruise1);

        assertThrows(ServiceException.class, () -> cruiseService.deleteCruise(MOCKED_ID1));
    }
}