package com.hackathon.appToMongoDB.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class SecondAudioController {
    private final GridFsTemplate secondAudioGridFsTemplate;

    @PostMapping("/upload/secondAudio")
    public ResponseEntity<String> uploadSecondAudio(@RequestParam("audio") MultipartFile audio) {
        try {
            DBObject metaData = new BasicDBObject();
            metaData.put("type", "secondAudio");
            metaData.put("title", audio.getOriginalFilename());

            secondAudioGridFsTemplate.store(audio.getInputStream(), audio.getOriginalFilename(), "audio/3gp", metaData);

            return ResponseEntity.ok("Second audio file uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed!");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}
