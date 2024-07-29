package com.hackathon.appToMongoDB.controller;

import com.hackathon.appToMongoDB.Domain.Transcript;
import com.hackathon.appToMongoDB.Service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TranscriptController {
    @Autowired
    private TranscriptService transcriptService;

    @GetMapping("/api/transcripts")
    public Optional<Transcript> getTranscriptByKey(@RequestParam int key) {
        return transcriptService.getTranscriptByKey(key);
    }
}
