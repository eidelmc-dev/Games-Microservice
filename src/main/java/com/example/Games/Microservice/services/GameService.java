package com.example.Games.Microservice.services;
import org.springframework.stereotype.Service;

import com.example.Games.Microservice.models.GameModel;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface GameService {
    GameModel fetchGame(String gameId);
    void deleteGame(String gameId);
    GameModel upateGame(GameModel gameModel);
    GameModel postGame(HttpServletRequest request,GameModel gameModel);
}
