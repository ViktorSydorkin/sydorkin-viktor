package com.homework6.service.inter;

import com.homework6.entity.dto.LinerDTO;

import java.util.List;

public interface LinerService {

    void saveLiner(LinerDTO linerDTO);

    LinerDTO getLinerById(long liner_id);

    List<LinerDTO> getAllLiners();

    void deleteLiner(long liner_id);

}
