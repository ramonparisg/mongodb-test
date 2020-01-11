package com.ramonparis.mongodb.test.controllers;

import com.ramonparis.mongodb.test.domain.Career;
import com.ramonparis.mongodb.test.payloads.ApiResponse;
import com.ramonparis.mongodb.test.services.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CareerController {

    private final CareerService careerService;


    @GetMapping("/careers")
    public ResponseEntity<?> findAllCareers() {
        List<Career> careers = careerService.findAll();
        return ResponseEntity.ok(careers);
    }

    @GetMapping("/career/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Career career = careerService.findById(id);
        return ResponseEntity.ok(career);
    }

    @PostMapping("/career")
    public ResponseEntity<?> create(@RequestBody Career career) {
        Career response = careerService.create(career);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse("OK", "Created successfully"));

    }

    @PutMapping("/career")
    public ResponseEntity<?> update(@RequestBody Career career) {
        Career response = careerService.update(career);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(new ApiResponse("OK", "Updated successfully"));

    }

    @DeleteMapping("/career/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Boolean response = careerService.delete(id);
        return ResponseEntity.ok().body(new ApiResponse("OK", "Deleted successfully"));
    }

}
