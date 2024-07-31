package com.hackathon.appToMongoDB.controller;

import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputCheckController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @PostMapping("/api/inputcheck/update")
    public ResponseEntity<Void> updateInputCheckKey(@RequestParam int key) {
        Query query = new Query(Criteria.where("key").is(1));
        Update update = new Update().set("key", key);

        UpdateResult result = mongoTemplate.updateFirst(query, update, "InputCheck");

        if (result.getMatchedCount() == 0) {
            return ResponseEntity.notFound().build();
        }

        if (result.getModifiedCount() > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
