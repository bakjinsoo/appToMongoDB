package com.hackathon.appToMongoDB.Repository;

import com.hackathon.appToMongoDB.Domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Score getMostRecentScore() {
        Query query = new Query()
                .with(Sort.by(Sort.Direction.DESC, "timestamp")) // timestamp 기준 내림차순 정렬
                .limit(1); // 결과를 하나만 가져옵니다

        return mongoTemplate.findOne(query, Score.class);
    }
}
