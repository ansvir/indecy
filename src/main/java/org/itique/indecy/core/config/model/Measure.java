package org.itique.indecy.core.config.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.List;

@Data
public class Measure {
    private String id;
    @JacksonXmlElementWrapper(localName = "includes")
    private List<String> indexId;
}
