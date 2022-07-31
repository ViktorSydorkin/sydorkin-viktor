package com.homework6.service.implementation;

import com.homework6.entity.User;
import com.homework6.entity.dto.UserDTO;
import com.homework6.entity.exception.RepositoryException;
import com.homework6.entity.exception.ServiceException;
import com.homework6.mappers.UserMapper;
import com.homework6.repository.inter.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final static String MOCKED_EMAIL1 = "email";
    private final static String MOCKED_EMAIL2 = "email2";
    private final static long MOCKED_ID = 1L;

    @Test
    void getUserByEmail() {
        User expected = User.builder().email(MOCKED_EMAIL1).build();
        when(userRepository.findByEmail(MOCKED_EMAIL1)).thenReturn(expected);

        UserDTO actualUser = userService.getUserByEmail(MOCKED_EMAIL1);

        assertEquals(expected.getEmail(), actualUser.getEmail());
    }

    @Test
    void getUserByEmailThrow() {
        when(userRepository.findByEmail(MOCKED_EMAIL1)).thenThrow(new RepositoryException("User wasn't found"));

        assertThrows(ServiceException.class, () -> userService.getUserByEmail(MOCKED_EMAIL1));
    }

    @Test
    void getAllUsers() {
        User user1 = User.builder().email(MOCKED_EMAIL1).build();
        User user2 = User.builder().email(MOCKED_EMAIL2).build();
        List<User> expected = List.of(user1, user2);
        when(userRepository.findAll()).thenReturn(expected);

        assertThat(userService.getAllUsers(), hasSize(2));
    }

    @Test
    void saveUser() {
        User expected = User.builder().email(MOCKED_EMAIL1).build();
        when(userRepository.save(expected)).thenReturn(expected);

        userService.saveUser(UserMapper.INSTANCE.toDTO(expected));

        verify(userRepository, times(1)).save(expected);
    }

    @Test
    void deleteUser() {
        User expected = User.builder().id(MOCKED_ID).build();
        when(userRepository.findById(MOCKED_ID)).thenReturn(Optional.of(expected));
        doNothing().when(userRepository).delete(expected);

        userService.deleteUser(MOCKED_ID);

        verify(userRepository, times(1)).delete(expected);
    }

    @Test
    void deleteUserThrow() {
        User expected = User.builder().id(MOCKED_ID).build();
        //doThrow(RepositoryException.class).when(userRepository).delete(expected);

        assertThrows(ServiceException.class, () -> userService.deleteUser(MOCKED_ID));
    }
}