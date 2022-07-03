package com.homework3.hw_3.service.inter;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.entity.dto.LinerDTO;

import java.util.List;

public interface LinerService {
    void addLiner(LinerDTO linerDTO);

    LinerDTO getLinerById(long liner_id);

    List<LinerDTO> getAllLiners(/*long lang_id*/);

    void updateLiner(LinerDTO linerDTO);

    void deleteLiner(long liner_id);
}
