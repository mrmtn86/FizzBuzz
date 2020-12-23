package com.oneio.fizzbuzz.dao;

import com.oneio.fizzbuzz.model.GameStateEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class GameStateRepositoryTest {

    @Autowired
    private GameStateRepository gameStateRepository;


    @Test
    @DisplayName("find by key returns entity")
    void findByKeyReturnEntity()   {

        GameStateEntity entity = new GameStateEntity();
        entity.setKey("asd");
       entity= gameStateRepository.save(entity);

        GameStateEntity result = gameStateRepository.findByKey("asd");

        assertThat(result.getId()).isEqualTo(entity.getId());

    }

}
