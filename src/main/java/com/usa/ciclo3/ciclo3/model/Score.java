package com.usa.ciclo3.ciclo3.model;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer score;
    private String messagetext;

    public Score() {


    }

    public Score(int score, String messagetext) {
        super();
        this.score = score;
        this.messagetext = messagetext;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }
}
