package com.ramonparis.mongodb.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    private int order;
    private String name;
    private String description;
    private String videoUrl;

}
