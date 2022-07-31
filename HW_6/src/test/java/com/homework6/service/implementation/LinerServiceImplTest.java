package com.homework6.service.implementation;

import com.homework6.entity.Liner;
import com.homework6.entity.Staff;
import com.homework6.entity.User;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.LinerMapper;
import com.homework6.mappers.StaffMapper;
import com.homework6.repository.inter.LinerRepository;
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
class LinerServiceImplTest {
    @Mock
    LinerRepository linerRepository;

    @InjectMocks
    LinerServiceImpl linerService;

    private final static long MOCKED_ID1 = 1L;
    private final static long MOCKED_ID2 = 2L;

    @Test
    void saveLiner() {
      Liner liner1 = Liner.builder().id(MOCKED_ID1).build();
        when(linerRepository.save(liner1)).thenReturn(liner1);

        linerService.saveLiner(LinerMapper.INSTANCE.toDTO(liner1));

        verify(linerRepository, times(1)).save(liner1);
    }

    @Test
    void getLinerById() {
        Liner liner1 = Liner.builder().id(MOCKED_ID1).build();
        when(linerRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(liner1));

        assertEquals(liner1, LinerMapper.INSTANCE.fromDTO(linerService.getLinerById(MOCKED_ID1)));
    }

    @Test
    void getAllLiners() {
        Liner liner1 = Liner.builder().id(MOCKED_ID1).build();
        Liner liner2 = Liner.builder().id(MOCKED_ID2).build();
        List<Liner> linerList = List.of(liner1, liner2);

        when(linerRepository.findAll()).thenReturn(linerList);

        assertThat(linerService.getAllLiners(), hasSize(2));
    }

    @Test
    void deleteLiner() {
        Liner liner1 = Liner.builder().id(MOCKED_ID1).build();
        when(linerRepository.findById(MOCKED_ID1)).thenReturn(Optional.of(liner1));
        doNothing().when(linerRepository).delete(liner1);

        linerService.deleteLiner(MOCKED_ID1);

        verify(linerRepository, times(1)).delete(liner1);
    }
    @Test
    void deleteLinerThrow() {
        Liner liner1 = Liner.builder().id(MOCKED_ID1).build();
        //doThrow(RepositoryException.class).when(linerRepository).delete(liner1);

        assertThrows(ServiceException.class, () -> linerService.deleteLiner(MOCKED_ID1));
    }
}