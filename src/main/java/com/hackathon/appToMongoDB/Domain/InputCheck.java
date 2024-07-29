package com.hackathon.appToMongoDB.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InputCheck")
public class InputCheck {
    @Id
    private String id;
    private int key;
}
