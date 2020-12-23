package com.oneio.fizzbuzz.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class FileOperator {

    Logger logger = LoggerFactory.getLogger(FileOperator.class);

    private final ResourceLoader resourceLoader;

    public FileOperator() {
        //not autowiring for tests
        resourceLoader = new DefaultResourceLoader();
    }

    Path getPath(String fileName) throws IOException {
        logger.debug("getPath : " + fileName);
        return resourceLoader.getResource(fileName).getFile().toPath();
    }

    public void writeToFile(String fileName, String data) throws IOException {

        logger.debug("writing to file  : " + fileName + " data : " + data);
        Path path = getPath(fileName);
        Files.write(path, data.getBytes());
    }

    public String readFile(String fileName) throws IOException {

        logger.debug("reading data from´ file  : " + fileName);

        Path path = getPath(fileName);

        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);
    }

}
