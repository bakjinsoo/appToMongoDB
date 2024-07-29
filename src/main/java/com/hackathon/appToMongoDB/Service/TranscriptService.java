package com.hackathon.appToMongoDB.Service;

import com.hackathon.appToMongoDB.Domain.InputCheck;
import com.hackathon.appToMongoDB.Domain.Transcript;
import com.hackathon.appToMongoDB.Repository.InputCheckRepository;
import com.hackathon.appToMongoDB.Repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
public class TranscriptService {
    @Autowired
    private InputCheckRepository inputCheckRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;

    public Optional<Transcript> getTranscriptByKey(int key) {
        Optional<InputCheck> inputCheck=inputCheckRepository.findByKey(key);
        if (inputCheck.isPresent()) {
            String fileId = inputCheckRepository.findByKey();
            return transcriptRepository.findByFileId(fileId);
        }
        return Optional.empty();
    }

}
