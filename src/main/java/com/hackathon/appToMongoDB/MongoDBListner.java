package com.hackathon.appToMongoDB;

import com.hackathon.appToMongoDB.Handler.WebSocketHandler;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoDBListner {
    @Autowired
    private MongoDatabase mongoDatabase;
    @Autowired
    private WebSocketHandler webSocketHandler;

}
