package com.ramonparis.mongodb.test.services;

import com.ramonparis.mongodb.test.domain.Career;
import com.ramonparis.mongodb.test.repositories.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;


    @Override
    public List<Career> findAll() {
        return careerRepository.findAll();
    }

    @Override
    public Career findById(String id) {
        return careerRepository.findById(id).orElse(new Career());
    }

    @Override
    public Career create(Career career) {
        return careerRepository.save(career);
    }

    @Override
    public Career update(Career career) {
        return careerRepository.save(career);
    }

    @Override
    public Boolean delete(String id) {
        careerRepository.deleteById(id);
        return true;
    }
}
