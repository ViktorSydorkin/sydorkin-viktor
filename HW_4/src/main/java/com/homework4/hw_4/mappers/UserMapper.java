package com.homework4.hw_4.mappers;

import com.homework4.hw_4.entity.User;
import com.homework4.hw_4.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User fromDTO(UserDTO userDTO);
}
