package com.usa.ciclo3.ciclo3.repository;


import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.model.Score;
import com.usa.ciclo3.ciclo3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score ss) {
        return scoreCrudRepository.save(ss);
    }

    public void delete(Score sd) {
        scoreCrudRepository.delete(sd);
    }
}
