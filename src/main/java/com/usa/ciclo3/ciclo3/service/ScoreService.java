package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.model.Score;
import com.usa.ciclo3.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score ss) {
        if (ss.getScore() == null) {
            return scoreRepository.save(ss);
        } else {
            Optional<Score> scoreAuxiliar = scoreRepository.getScore(ss.getScore());
            if (scoreAuxiliar.isEmpty()) {
                return scoreRepository.save(ss);
            } else {
                return ss;
            }
        }
    }

    public Score update(Score sup) {
        if (sup.getScore() != null) {
            Optional<Score> scoreAuxiliar = scoreRepository.getScore(sup.getScore());
            if (scoreAuxiliar.isPresent()) {
                if (sup.getMessagetext() != null) {
                    scoreAuxiliar.get().setMessagetext(sup.getMessagetext());
                }
                return scoreRepository.save(scoreAuxiliar.get());
            }
        }
        return sup;

    }

    public boolean deleteScore(int id) {
        Optional<Score> scoreAuxiliar = getScore(id);
        if (scoreAuxiliar.isPresent()) {
            scoreRepository.delete(scoreAuxiliar.get());
            return true;
        }
        return false;

    }

}
