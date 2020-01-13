package com.ramonparis.mongodb.test.controllers;

import com.ramonparis.mongodb.test.domain.Course;
import com.ramonparis.mongodb.test.payloads.ApiResponse;
import com.ramonparis.mongodb.test.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(courseService.findAll());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/course")
    public ResponseEntity<?> create(@RequestBody Course course) {
        Course response = courseService.create(course);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse("OK", "Created successfully"));

    }

    @PutMapping("/course")
    public ResponseEntity<?> update(@RequestBody Course course) {
        Course response = courseService.update(course);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse("OK", "Updated successfully"));

    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Boolean response = courseService.delete(id);
        return ResponseEntity.ok().body(new ApiResponse("OK", "Deleted successfully"));
    }




}
