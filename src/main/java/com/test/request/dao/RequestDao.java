package com.test.request.dao;

import com.test.request.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDao extends MongoRepository<Request, Integer> {
}
