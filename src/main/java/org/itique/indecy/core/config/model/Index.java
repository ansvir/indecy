package org.itique.indecy.core.config.model;

import lombok.Data;

import java.util.Optional;

@Data
public class Index {
    private String id;
    private Optional<Double> initValue;
}
