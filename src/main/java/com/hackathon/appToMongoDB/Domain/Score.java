package com.hackathon.appToMongoDB.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "scores")
public class Score {
    @Id
    private String id;
    private int inverse_number_score;
    private int drawing_score;
    private int animal_name_score;
    private int total_score;
    private Instant timestamp;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInverseNumberScore() {
        return inverse_number_score;
    }

    public void setInverseNumberScore(int inverse_number_score) {
        this.inverse_number_score = inverse_number_score;
    }

    public int getDrawingScore() {
        return drawing_score;
    }

    public void setDrawingScore(int drawing_score) {
        this.drawing_score = drawing_score;
    }

    public int getAnimalNameScore() {
        return animal_name_score;
    }

    public void setAnimalNameScore(int animal_name_score) {
        this.animal_name_score = animal_name_score;
    }

    public int getTotalScore() {
        return total_score;
    }

    public void setTotalScore(int total_score) {
        this.total_score = total_score;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
