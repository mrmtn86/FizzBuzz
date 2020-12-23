package com.oneio.fizzbuzz.dao;

import com.oneio.fizzbuzz.exception.FileOperationException;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;


class FizzBuzzRepositoryTest {

    @Test
    @DisplayName("setNumber Throws FileOperationException When Catches IOException")
    void setNumberThrowsFileOperationWhenCatchesIOException() throws IOException {


        FileOperator fileOperator = Mockito.mock(FileOperator.class);

        doThrow(new IOException()).when(fileOperator).writeToFile(anyString(),anyString());



        FizzBuzzRepository fizzBuzzRepository = new FizzBuzzRepository(fileOperator);


        Assert.assertThrows(FileOperationException.class, () -> fizzBuzzRepository.setNumber(4));

    }

    @Test
    @DisplayName("getNumber Throws FileOperationException When Catches IOException")
    void getNumberThrowsFileOperationWhenCatchesIOException() throws IOException {


        FileOperator fileOperator = Mockito.mock(FileOperator.class);
        Mockito.when(fileOperator.readFile(anyString())).thenThrow(new IOException());


        FizzBuzzRepository fizzBuzzRepository = new FizzBuzzRepository(fileOperator);


        Assert.assertThrows(FileOperationException.class, fizzBuzzRepository::getNumber);

    }

}
