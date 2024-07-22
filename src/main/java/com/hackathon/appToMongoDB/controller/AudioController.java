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
public class AudioController {
    private final GridFsTemplate gridFsTemplate;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudio(@RequestParam("audio") MultipartFile audio) {
        try {
            DBObject metaData = new BasicDBObject();
            metaData.put("type", "audio");
            metaData.put("title", audio.getOriginalFilename());

            gridFsTemplate.store(audio.getInputStream(), audio.getOriginalFilename(), "audio/3gp", metaData);

            return ResponseEntity.ok("File uploaded successfully!");
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
