package com.homework6.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework6.TestConfig;
import com.homework6.entity.dto.UserDTO;
import com.homework6.service.inter.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import(TestConfig.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private
    ObjectMapper objectMapper;

    private static final long USER_ID = 1;
    private static final String USER_EMAIL1 = "email1@gmail.com";
    private static final String USER_EMAIL2 = "email2@gmail.com";
    private static final String INVALID_EMAIL = "email2";
    private static final String MOCK_URL = "/user/";
    private static final String PASSWORD = "qwaszx123";
    private static final String NAME = "Name";
    private static final String INVALID_NAME = "";
    private static final String SURNAME = "Surname";
    private static final String ROLE = "User";

    @Test
    void getUserByEmail() throws Exception {
        UserDTO userDTO = UserDTO.builder().email(USER_EMAIL1).build();

        when(userService.getUserByEmail(USER_EMAIL1)).thenReturn(userDTO);

        mockMvc.perform(
                        get(MOCK_URL + USER_EMAIL1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(USER_EMAIL1));
    }

    @Test
    void getAllUsers() throws Exception {
        UserDTO user1 = UserDTO.builder().email(USER_EMAIL1).build();
        UserDTO user2 = UserDTO.builder().email(USER_EMAIL2).build();
        List<UserDTO> userDTOList = List.of(user1, user2);

        when(userService.getAllUsers()).thenReturn(userDTOList);

        mockMvc.perform(
                        get(MOCK_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].email").value(USER_EMAIL1))
                .andExpect(jsonPath("$[1].email").value(USER_EMAIL2));
    }

    @Test
    void createUser() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(NAME).surname(SURNAME).email(USER_EMAIL1).password(PASSWORD).role(ROLE).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))
                .andDo(print())
                .andExpect(status().isCreated());

        verify(userService).saveUser(user1);
    }

    @Test
    void createInvalidUserName() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(INVALID_NAME).surname(SURNAME).email(USER_EMAIL1).password(PASSWORD).role(ROLE).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))

                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void createInvalidUserEmail() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(NAME).surname(SURNAME).email(INVALID_EMAIL).password(PASSWORD).role(ROLE).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))

                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void createInvalidUserPassword() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(NAME).surname(SURNAME).email(USER_EMAIL1).password(INVALID_NAME).role(ROLE).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))

                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void createInvalidUserRole() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(NAME).surname(SURNAME).email(USER_EMAIL1).password(PASSWORD).role(null).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        post(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))

                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    void updateUser() throws Exception {
        UserDTO user1 = UserDTO.builder().id(USER_ID).name(NAME).surname(SURNAME).email(USER_EMAIL1).password(PASSWORD).role(ROLE).build();

        doNothing().when(userService).saveUser(user1);

        mockMvc.perform(
                        put(MOCK_URL).contentType("application/json")
                                .content(objectMapper.writeValueAsString(user1)))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userService).saveUser(user1);
    }

    @Test
    void deleteUser() throws Exception {
        doNothing().when(userService).deleteUser(USER_ID);

        mockMvc.perform(
                        delete(MOCK_URL + USER_ID))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userService).deleteUser(USER_ID);
    }
}