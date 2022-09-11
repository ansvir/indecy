package org.itique.indecy.core.config.model;

import lombok.Data;

import java.util.List;

@Data
public class Context {
    private List<Index> indices;
    private List<Measure> measures;
    private List<Parameter> parameters;
}
