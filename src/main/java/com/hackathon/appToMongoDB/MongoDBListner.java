package com.hackathon.appToMongoDB;

import com.hackathon.appToMongoDB.Handler.WebSocketHandler;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MongoDBListner {
    @Autowired
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    @Autowired
    private WebSocketHandler webSocketHandler;
    @PostConstruct
    public void init() {
        mongoDatabase=mongoClient.getDatabase("Dementia");
        new Thread(() -> {
            var changeStream = mongoDatabase.getCollection("transcripts").watch();
            for (ChangeStreamDocument<Document> change : changeStream) {
                Document doc = change.getFullDocument();
                String text = doc.getString("text");
                try {
                    webSocketHandler.sendMessageToClients(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
