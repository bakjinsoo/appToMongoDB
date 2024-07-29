package com.hackathon.appToMongoDB.Repository;

import com.hackathon.appToMongoDB.Domain.InputCheck;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InputCheckRepository extends MongoRepository<InputCheck ,String> {
    Optional<InputCheck> findByKey(int key);

}
