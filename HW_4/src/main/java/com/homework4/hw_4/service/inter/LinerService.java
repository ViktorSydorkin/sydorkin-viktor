package com.homework4.hw_4.service.inter;

import com.homework4.hw_4.entity.dto.LinerDTO;

import java.util.List;

public interface LinerService {

    void addLiner(LinerDTO linerDTO);

    LinerDTO getLinerById(long liner_id);

    List<LinerDTO> getAllLiners();

    void updateLiner(LinerDTO linerDTO);

    void deleteLiner(long liner_id);

}
