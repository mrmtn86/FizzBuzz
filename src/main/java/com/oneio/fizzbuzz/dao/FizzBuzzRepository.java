package com.oneio.fizzbuzz.dao;


import com.oneio.fizzbuzz.exception.FileOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class FizzBuzzRepository {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzRepository.class);

    private final FileOperator fileOperator;

    public static final String NUMBER_CONTAINER_FILE_NAME = "number-container";

    public FizzBuzzRepository(FileOperator fileOperator) {
        this.fileOperator = fileOperator;
    }


    public void setNumber(int number) throws FileOperationException {
        try {
            fileOperator.writeToFile(NUMBER_CONTAINER_FILE_NAME, "" + number);
        } catch (IOException e) {

            logger.error("error while writing number(" + number + ") to file : " + NUMBER_CONTAINER_FILE_NAME, e);

            throw new FileOperationException("error while storing number");
        }
    }

    public int getNumber() throws FileOperationException {

        try {
            String data = fileOperator.readFile(NUMBER_CONTAINER_FILE_NAME);
            return Integer.parseInt(data);
        } catch (IOException e) {
            logger.error("error while writing to file : " + NUMBER_CONTAINER_FILE_NAME, e);
            throw new FileOperationException("error while reading number");

        }
    }
}
