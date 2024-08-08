package com.hackathon.appToMongoDB.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class PhotoController {

    private final GridFsTemplate photoGridFsTemplate;

    @PostMapping("/upload/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam("photo")MultipartFile photo) {
        try {
            DBObject metaData = new BasicDBObject();
            metaData.put("type", "photo");
            metaData.put("title", photo.getOriginalFilename());
            photoGridFsTemplate.store(photo.getInputStream(), photo.getOriginalFilename(), "image/jpeg", metaData);
            return ResponseEntity.ok("photo upload success");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("photo upload fail");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
    }
}
