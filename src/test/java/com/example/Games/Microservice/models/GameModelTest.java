package com.example.Games.Microservice.models;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class GameModelTest {


    @Test
    void testGame(){
        GameModel game = new GameModel();
        game.setGame_id((long)  1);
        game.setGame_level((long)  1);
        game.setGame_score((long)  1);
        game.setGame_update(LocalDateTime.now());
        game.setGame_user_id((long)  1);
    }
    
}
