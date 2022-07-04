package com.homework4.hw_4.repository.inter;

import com.homework4.hw_4.entity.Liner;

import java.util.List;

public interface LinerRepository {
    void addLiner(Liner liner);

    Liner getLinerById(long liner_id);

    List<Liner> getAllLiners(/*long lang_id*/);

    void updateLiner(Liner liner);

    void deleteLiner(long liner_id);
}
