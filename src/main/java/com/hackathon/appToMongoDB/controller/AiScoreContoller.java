package com.hackathon.appToMongoDB.controller;

import com.hackathon.appToMongoDB.Domain.AiScore;
import com.hackathon.appToMongoDB.Repository.AiScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiScoreContoller {
    @Autowired
    private AiScoreService aiScoreService;

    @GetMapping("/ai_score")
    public AiScore getLatestAiScore() {
        return aiScoreService.getMostRecentAiScore();
    }
}
