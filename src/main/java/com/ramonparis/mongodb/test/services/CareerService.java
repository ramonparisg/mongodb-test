package com.ramonparis.mongodb.test.services;

import com.ramonparis.mongodb.test.domain.Career;

import java.util.List;

public interface CareerService {

    List<Career> findAll();

    Career findById(String id);

    Career create(Career career);

    Career update(Career career);

    Boolean delete(String id);

}
