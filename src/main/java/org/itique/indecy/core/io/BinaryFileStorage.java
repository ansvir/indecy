package org.itique.indecy.core.io;

import org.itique.indecy.core.exception.IndecyRuntimeException;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

public class BinaryFileStorage {

    private byte[] config;
    private byte[] iy;

    public BinaryFileStorage() {
    }

    @PostConstruct
    public void init() {
        reloadConfig();
    }

    public byte[] reloadConfig() {
        this.config = readConfig();
        return this.config;
    }

    public byte[] reloadIy(String name) {
        this.iy = readIy(name);
        return this.iy;
    }

    private byte[] readConfig() {
        return readResource("indecy/config.xml");
    }

    private byte[] readIy(String name) {
        return readResource(name);
    }

    private byte[] readResource(String path) {
        byte[] resource;
        try (InputStream resourceStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(path)) {
            resource = resourceStream.readAllBytes();
        } catch (IOException e) {
            throw new IndecyRuntimeException();
        }
        return resource;
    }
}
