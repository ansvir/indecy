package org.itique.indecy.core.bean;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.itique.indecy.core.io.BinaryFileStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.itique.indecy.core.config.marshaller", "org.itique.indecy.core.io"})
public class IndecyConfig {

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }

    @Bean
    public BinaryFileStorage fileStorage() {
        return new BinaryFileStorage();
    }
}
