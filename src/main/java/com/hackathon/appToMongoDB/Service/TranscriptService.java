package com.hackathon.appToMongoDB.Service;

import com.hackathon.appToMongoDB.Domain.InputCheck;
import com.hackathon.appToMongoDB.Domain.Transcript;
import com.hackathon.appToMongoDB.Repository.InputCheckRepository;
import com.hackathon.appToMongoDB.Repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class TranscriptService {
    @Autowired
    private InputCheckRepository inputCheckRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Optional<Transcript> getLatestTranscriptIfInputCheckIsOne() {
        Query inputCheckQuery = new Query();
        inputCheckQuery.addCriteria(Criteria.where("key").is(1));
        boolean isInputCheckOne = mongoTemplate.exists(inputCheckQuery, "InputCheck");

        if (!isInputCheckOne) {
            return Optional.empty();
        }
        Query transcriptQuery = new Query();
        transcriptQuery.with(Sort.by(Sort.Direction.DESC, "timestamp")); // Sort by timestamp in descending order
        transcriptQuery.limit(1);
        List<Transcript> transcripts = mongoTemplate.find(transcriptQuery, Transcript.class);

        if (transcripts.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(transcripts.get(0));
    }

}
