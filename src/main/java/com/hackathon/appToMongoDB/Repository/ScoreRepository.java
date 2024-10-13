package com.hackathon.appToMongoDB.Repository;

import com.hackathon.appToMongoDB.Domain.Score;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends MongoRepository<Score, String> {
    Score findTopByOrderByTimestampDesc();
}
