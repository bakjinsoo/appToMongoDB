package com.hackathon.appToMongoDB.Repository;

import com.hackathon.appToMongoDB.Domain.AiScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiScoreService {
    @Autowired
    private AiScoreRepository aiScoreRepository;

    public AiScore getMostRecentAiScore() {
        return aiScoreRepository.findTopByOrderByTimestampDesc();
    }
}
