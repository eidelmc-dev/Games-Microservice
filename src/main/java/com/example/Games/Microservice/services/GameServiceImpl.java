package com.example.Games.Microservice.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.example.Games.Microservice.models.GameModel;
import com.example.Games.Microservice.repository.GameRepository;



@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

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
        Long gameId = gameModel.getGame_id();
        GameModel existingGame =  gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game Not Found."));
        if (gameModel.getGame_level() != null) {
            existingGame.setGame_level(gameModel.getGame_level());
        }
        if (gameModel.getGame_score() != null) {
            existingGame.setGame_score(gameModel.getGame_score());
        }
        if (gameModel.getGame_user_id() != null) {
            existingGame.setGame_user_id(gameModel.getGame_user_id());
        }
        existingGame.setGame_update(LocalDateTime.now());;

       return gameRepository.save(existingGame);
    }


    @Override
    public GameModel postGame(GameModel gameModel) {
        gameModel.setGame_update(LocalDateTime.now());;
        GameModel gameSaved = gameRepository.save(gameModel);
        return gameSaved;
    }
    
    
}
