package com.hackathon.appToMongoDB.Repository;

import com.hackathon.appToMongoDB.Domain.Transcript;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TranscriptRepository extends MongoRepository<Transcript,String> {
    Optional<Transcript> findByFileId(String fileId);
}
