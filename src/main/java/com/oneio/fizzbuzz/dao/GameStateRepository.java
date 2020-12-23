package com.oneio.fizzbuzz.dao;


import com.oneio.fizzbuzz.model.GameStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStateRepository extends JpaRepository<GameStateEntity, Long> {

    GameStateEntity findByKey(String key);

}
