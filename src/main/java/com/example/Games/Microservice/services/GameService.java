package com.example.Games.Microservice.services;
import org.springframework.stereotype.Service;

import com.example.Games.Microservice.models.GameModel;

@Service
public interface GameService {
    GameModel fetchGame(String gameId);
    void deleteGame(String gameId);
    GameModel upateGame(GameModel gameModel);
    GameModel postGame(GameModel gameModel);
}
