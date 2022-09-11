package org.itique.indecy.core.config.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.Optional;

@Data
public class Parameter {
    private String name;
    private Optional<Double> initValue;
}
