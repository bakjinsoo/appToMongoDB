package com.hackathon.appToMongoDB.controller;

import com.hackathon.appToMongoDB.Domain.Score;
import com.hackathon.appToMongoDB.Repository.ScoreRepository;
import com.hackathon.appToMongoDB.Repository.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService; // ScoreService 주입

    @GetMapping("/score")
    public Score getLatestScore() {
        return scoreService.getMostRecentScore(); // ScoreService에서 최신 Score 가져오기
    }
}
