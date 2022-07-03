package com.homework3.hw_3.mappers;

import com.homework3.hw_3.entity.User;
import com.homework3.hw_3.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper  INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);
    User fromDTO(UserDTO userDTO);
}
