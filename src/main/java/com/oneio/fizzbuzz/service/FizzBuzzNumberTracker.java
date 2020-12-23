package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.dao.GameStateRepository;
import com.oneio.fizzbuzz.model.GameStateEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class FizzBuzzNumberTracker {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzNumberTracker.class);
    public static final String KEY = "fizzbuzz";

    private final GameStateRepository gameStateRepository;

    public FizzBuzzNumberTracker(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public int start() {
        logger.debug("start game");
        int number = 1;
        GameStateEntity gameStateEntity = gameStateRepository.findByKey(KEY);

        if (gameStateEntity == null) {
            gameStateEntity = new GameStateEntity();
            gameStateEntity.setKey(KEY);

        }

        gameStateEntity.setValue(1);
        gameStateRepository.save(gameStateEntity);

        return number;
    }

    public int next() {

        GameStateEntity gameState = gameStateRepository.findByKey(KEY);

        if (gameState == null) {

            throw new RuntimeException("game state could not found. Try to restart game");
        }

        int number = gameState.getValueAsInt();
        gameState.setValue(++number);

        gameStateRepository.save(gameState);

        logger.debug("to next number : " + number);

        return number;
    }

    public void reset() {

        logger.debug("reset game");

        GameStateEntity gameState = gameStateRepository.findByKey(KEY);

        if (gameState == null) {
            gameState = new GameStateEntity();
            gameState.setKey(KEY);
        }

        gameState.setValue(0);
        gameStateRepository.save(gameState);

    }
}
