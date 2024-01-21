package com.example.Games.Microservice.services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.example.Games.Microservice.models.GameModel;
import com.example.Games.Microservice.repository.GameRepository;
import com.example.Games.Microservice.services.GameService;
import com.example.Games.Microservice.services.JwtokenService;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private JwtokenService jwtokenService;

    @Override
    public GameModel fetchGame(String gameId) {
       Long gameid = Long.parseLong(gameId);
       GameModel gameFetched = gameRepository.findById(gameid).orElseThrow(() -> new RuntimeException("No Game Found")); 
    return gameFetched;
    }

    @Override
    public void deleteGame(String gameId) {
        Long gameIdLong = Long.parseLong(gameId);
        gameRepository.deleteById(gameIdLong);
    }

    @Override
    public GameModel upateGame(GameModel gameModel) {


       return gameRepository.save(gameModel);
    }


    @Override
    public GameModel postGame(HttpServletRequest request,GameModel gameModel) {
        String token = jwtokenService.extractToken(request);
        Long userId = jwtokenService.getUserIdFromToken(token);

        gameModel.setGame_user_id(userId);

        gameModel.setGame_update(LocalDateTime.now());;
        GameModel gameSaved = gameRepository.save(gameModel);
        return gameSaved;
    }
    
    
}
