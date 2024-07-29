package com.hackathon.appToMongoDB.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transcripts")
public class Transcript {
    @Id
    private String id;
    private String fieldId;
    private String text;
}
