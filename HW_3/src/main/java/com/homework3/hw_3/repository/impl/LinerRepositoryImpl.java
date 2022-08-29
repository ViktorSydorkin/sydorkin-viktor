package com.homework3.hw_3.repository.impl;

import com.homework3.hw_3.entity.Liner;
import com.homework3.hw_3.repository.inter.LinerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinerRepositoryImpl implements LinerRepository {

    @Override
    public void addLiner(Liner liner) {
    }

    @Override
    public Liner getLinerById(long linerId) {
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
    public void deleteLiner(long linerId) {
    }
}
