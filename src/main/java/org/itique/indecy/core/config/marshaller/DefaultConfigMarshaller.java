package org.itique.indecy.core.config.marshaller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.itique.indecy.core.config.model.Configuration;
import org.itique.indecy.core.exception.IndecyRuntimeException;
import org.itique.indecy.core.io.BinaryFileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultConfigMarshaller implements ConfigMarshaller {

    private XmlMapper xmlMapper;
    private BinaryFileStorage fileStorage;

    @Autowired
    public DefaultConfigMarshaller(XmlMapper xmlMapper, BinaryFileStorage fileStorage) {
        this.xmlMapper = xmlMapper;
        this.fileStorage = fileStorage;
    }

    @Override
    public Configuration unmarshall() {
        Configuration config;
        try {
            config = xmlMapper.readValue(fileStorage.reloadConfig(), Configuration.class);
        } catch (IOException e) {
            throw new IndecyRuntimeException();
        }
        return config;
    }
}
