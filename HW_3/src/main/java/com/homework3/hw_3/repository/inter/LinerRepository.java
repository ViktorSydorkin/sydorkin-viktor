package com.homework3.hw_3.repository.inter;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.entity.dto.LinerDTO;

import java.util.List;

public interface LinerRepository {
    void addLiner(Liner liner);

    Liner getLinerById(long liner_id);

    List<Liner> getAllLiners(/*long lang_id*/);

    void updateLiner(Liner liner);

    void deleteLiner(long liner_id);
}
