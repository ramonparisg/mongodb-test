package com.ramonparis.mongodb.test.services;

import com.ramonparis.mongodb.test.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(String id);

    Course create(Course course);

    Course update(Course course);

    Boolean delete(String id);

}
