package com.ramonparis.mongodb.test.repositories;

import com.ramonparis.mongodb.test.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
