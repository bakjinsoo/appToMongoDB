package com.hackathon.appToMongoDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "Dementia";  // 여기에 실제 데이터베이스 이름을 입력하세요
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public GridFsTemplate photoGridFsTemplate(MongoDatabaseFactory dbFactory, MongoTemplate mongoTemplate) {
        return new GridFsTemplate(dbFactory, mongoTemplate.getConverter(), "photos");
    }

    @Bean
    public GridFsTemplate audioGridFsTemplate(MongoDatabaseFactory dbFactory, MongoTemplate mongoTemplate) {
        return new GridFsTemplate(dbFactory, mongoTemplate.getConverter(), "audios");
    }
}
