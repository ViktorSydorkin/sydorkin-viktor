package com.homework4.hw_4.repository.impl;

import com.homework4.hw_4.entity.Liner;
import com.homework4.hw_4.repository.inter.LinerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinerRepositoryImpl implements LinerRepository {

    @Override
    public void addLiner(Liner liner) {
    }

    @Override
    public Liner getLinerById(long liner_id) {
        return null;
    }

    @Override
    public List<Liner> getAllLiners() {
        return null;
    }

    @Override
    public void updateLiner(Liner liner) {
    }

    @Override
    public void deleteLiner(long liner_id) {
    }
}
