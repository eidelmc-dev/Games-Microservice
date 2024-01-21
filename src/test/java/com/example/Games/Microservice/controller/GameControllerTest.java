package com.example.Games.Microservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Games.Microservice.models.GameModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {
     @Autowired
    private MockMvc mockMvc;


    @SneakyThrows
    @Test
    void saveGame(){
        GameModel game = new GameModel();
        game.setGame_level((long)  1);
        game.setGame_score((long)  1);
        game.setGame_update(LocalDateTime.now());
        game.setGame_user_id((long)  1);
        ObjectMapper objectMapper = new ObjectMapper();
       this.mockMvc.perform(post("/api/games").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(game))
        ).andExpect(status().isOk() );
    
    }

    @SneakyThrows
    @Test
    void updateGame(){
        GameModel game = new GameModel();
        game.setGame_level((long)  1);
        game.setGame_score((long)  1);
        game.setGame_update(LocalDateTime.now());
        game.setGame_user_id((long)  1);
        ObjectMapper objectMapper = new ObjectMapper();
       this.mockMvc.perform(put("/api/games").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(game))
        ).andExpect(status().isOk() );
    
    }

    @SneakyThrows
    @Test
    void getGame(){
     this.mockMvc.perform(get("/api/games?id=1").contentType(MediaType.APPLICATION_JSON)
     ).andExpect(status().isOk());
    }



    @SneakyThrows
    @Test
    void deleteGame(){
     this.mockMvc.perform(delete("/api/games?id=1").contentType(MediaType.APPLICATION_JSON)
     ).andExpect(status().isNonAuthoritativeInformation())  ; 
    }

}
