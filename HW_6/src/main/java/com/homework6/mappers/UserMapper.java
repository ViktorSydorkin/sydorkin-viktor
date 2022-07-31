package com.homework6.mappers;

import com.homework6.entity.User;
import com.homework6.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    User fromDTO(UserDTO userDTO);

}
