package com.oneio.fizzbuzz.dao;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.oneio.fizzbuzz.dao.FizzBuzzRepository.NUMBER_CONTAINER_FILE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

class FileOperatorTest {


    @Test
    @DisplayName("File name should exist in the path")
    void getPathShouldReturnContainingFilePath() throws IOException {

        FileOperator fileOperator = new FileOperator();


        Path path = fileOperator.getPath(NUMBER_CONTAINER_FILE_NAME);


        assertThat(path).isNotNull();
        assertThat(path.getFileName()).hasFileName(NUMBER_CONTAINER_FILE_NAME);

    }

    @Test
    @DisplayName("File name should throw IOException for non existing file")
    void getPathShouldThrowExceptionForNonExistingFile() {

        FileOperator fileOperator = new FileOperator();


        Assert.assertThrows(IOException.class, () -> fileOperator.getPath("random file name"));

    }

    @Test
    @DisplayName("writeToFile Should write to file")
    void writeToFileShouldWriteIt() throws IOException {

        FileOperator fileOperator = new FileOperator();

        String hello_hello_hello = "hello hello hello";

        Path path = fileOperator.getPath(NUMBER_CONTAINER_FILE_NAME);


        fileOperator.writeToFile(NUMBER_CONTAINER_FILE_NAME, hello_hello_hello);


        assertThat(Files.readAllBytes(path)).isEqualTo(hello_hello_hello.getBytes(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("writeToFile Should throw IOException for non existing file")
    void writeToFileSShouldThrowExceptionForNonExistingFile() {

        FileOperator fileOperator = new FileOperator();

        String hello_hello_hello = "hello hello hello";


        Assert.assertThrows(IOException.class, () -> fileOperator.writeToFile(hello_hello_hello, hello_hello_hello));

    }

    @Test
    @DisplayName("read File Should Read Data From File")
    void readFileShouldReadDataFromFile() throws IOException {


        FileOperator fileOperator = new FileOperator();

        String hello_hello_hello = "hello hello hello";

        fileOperator.writeToFile(NUMBER_CONTAINER_FILE_NAME, hello_hello_hello);


        String readFileResult = fileOperator.readFile(NUMBER_CONTAINER_FILE_NAME);


        assertThat(readFileResult).isEqualTo(hello_hello_hello);
    }
}
