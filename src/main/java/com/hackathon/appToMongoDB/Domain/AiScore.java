package com.hackathon.appToMongoDB.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "ai_scores")
public class AiScore {
    @Id
    private String id;

    private String inverseFileId;
    private String similarFileId;
    private int aiScore;
    private Instant timestamp;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getInverseFileId() { return inverseFileId; }
    public void setInverseFileId(String inverseFileId) { this.inverseFileId = inverseFileId; }

    public String getSimilarFileId() { return similarFileId; }
    public void setSimilarFileId(String similarFileId) { this.similarFileId = similarFileId; }

    public int getAiScore() { return aiScore; }
    public void setAiScore(int aiScore) { this.aiScore = aiScore; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
