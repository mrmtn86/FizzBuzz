package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.dao.FizzBuzzRepository;
import com.oneio.fizzbuzz.exception.FileOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class FizzBuzzNumberTracker {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzNumberTracker.class);

    private final FizzBuzzRepository fizzBuzzRepository;

    public FizzBuzzNumberTracker(FizzBuzzRepository fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }

    public int start() throws FileOperationException {
        logger.debug("start game");
        int number = 1;
        fizzBuzzRepository.setNumber(number);
        return number;
    }

    public int next() throws FileOperationException {

        int number = fizzBuzzRepository.getNumber();
        fizzBuzzRepository.setNumber(++number);

        logger.debug("to next number : " + number);

        return number;
    }

    public void reset() throws FileOperationException {

        logger.debug("reset game");

        fizzBuzzRepository.setNumber(0);
    }
}
