package com.ramonparis.mongodb.test.services;

import com.ramonparis.mongodb.test.domain.Course;
import com.ramonparis.mongodb.test.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(String id) {
        return courseRepository.findById(id).orElse(new Course());
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Boolean delete(String id) {
        courseRepository.deleteById(id);
        return true;
    }
}
