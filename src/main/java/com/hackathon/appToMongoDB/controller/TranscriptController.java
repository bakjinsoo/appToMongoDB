package com.hackathon.appToMongoDB.controller;

import com.hackathon.appToMongoDB.Domain.Transcript;
import com.hackathon.appToMongoDB.Service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TranscriptController {
    @Autowired
    private TranscriptService transcriptService;

    @GetMapping("/api/transcripts/latest")
    public ResponseEntity<Transcript> getLatestTranscriptIfInputCheckIsOne() {
        Optional<Transcript> transcript = transcriptService.getLatestTranscriptIfInputCheckIsOne();
        return transcript.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
