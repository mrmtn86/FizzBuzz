package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.dao.FizzBuzzRepository;
import com.oneio.fizzbuzz.exception.FileOperationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzNumberTrackerTest {

    @Test
    @DisplayName("start should set number to one")
    void startShouldSetNumberToOne() throws FileOperationException {
        FizzBuzzRepository fizzBuzzRepository = Mockito.mock(FizzBuzzRepository.class);
        Mockito.doNothing().when(fizzBuzzRepository).setNumber(1);
        FizzBuzzNumberTracker fizzBuzzNumberTracker = new FizzBuzzNumberTracker(fizzBuzzRepository);



        int start = fizzBuzzNumberTracker.start();



        assertThat(start).isEqualTo(1);

    }

    @Test
    @DisplayName("next should return next number")
    void next() throws FileOperationException {
        FizzBuzzRepository fizzBuzzRepository = Mockito.mock(FizzBuzzRepository.class);
        Mockito.doNothing().when(fizzBuzzRepository).setNumber(11);
        Mockito.when(fizzBuzzRepository.getNumber()).thenReturn(10);
        FizzBuzzNumberTracker fizzBuzzNumberTracker = new FizzBuzzNumberTracker(fizzBuzzRepository);



        int next = fizzBuzzNumberTracker.next();



        assertThat(next).isEqualTo(11);
    }

    @Test
    @DisplayName("reset should set number to zero")
    void reset() throws FileOperationException {
        FizzBuzzRepository fizzBuzzRepository = Mockito.mock(FizzBuzzRepository.class);

        //should call with zero this is test
        Mockito.doNothing().when(fizzBuzzRepository).setNumber(0);

        FizzBuzzNumberTracker fizzBuzzNumberTracker = new FizzBuzzNumberTracker(fizzBuzzRepository);


         fizzBuzzNumberTracker.reset();

    }
}
