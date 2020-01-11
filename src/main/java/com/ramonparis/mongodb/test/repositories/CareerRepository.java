package com.ramonparis.mongodb.test.repositories;

import com.ramonparis.mongodb.test.domain.Career;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CareerRepository extends MongoRepository<Career, String> {



}
