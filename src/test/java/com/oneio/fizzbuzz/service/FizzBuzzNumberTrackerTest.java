package com.oneio.fizzbuzz.service;

import com.oneio.fizzbuzz.dao.GameStateRepository;
import com.oneio.fizzbuzz.model.GameStateEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.oneio.fizzbuzz.service.FizzBuzzNumberTracker.KEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class FizzBuzzNumberTrackerTest {

    @Test
    @DisplayName("start should set number to one")
    void startShouldSetNumberToOne() {
        GameStateRepository gameStateRepository = Mockito.mock(GameStateRepository.class);
        when(gameStateRepository.findByKey(KEY)).thenReturn(new GameStateEntity());
        FizzBuzzNumberTracker fizzBuzzNumberTracker = new FizzBuzzNumberTracker(gameStateRepository);


        int start = fizzBuzzNumberTracker.start();


        assertThat(start).isEqualTo(1);

    }

    @Test
    @DisplayName("next should return next number")
    void next() {
        GameStateRepository gameStateRepository = Mockito.mock(GameStateRepository.class);

        GameStateEntity stateEntity = new GameStateEntity();
        stateEntity.setValue(10);
        when(gameStateRepository.findByKey(KEY)).thenReturn(stateEntity);
        FizzBuzzNumberTracker fizzBuzzNumberTracker = new FizzBuzzNumberTracker(gameStateRepository);


        int next = fizzBuzzNumberTracker.next();


        assertThat(next).isEqualTo(11);
    }

}
