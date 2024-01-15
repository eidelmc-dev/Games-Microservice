package com.example.Games.Microservice.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Games.Microservice.models.GameModel;
import com.example.Games.Microservice.services.GameService;
import com.example.Games.Microservice.services.JwtokenService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private JwtokenService jwtokenService;
    
    @GetMapping
    public ResponseEntity<GameModel> getGame(@RequestParam(value = "id") String gameId) {
           GameModel gameFetched =  gameService.fetchGame(gameId);
        return new ResponseEntity<>( gameFetched, HttpStatusCode.valueOf(200));
    }


    @PostMapping
    public ResponseEntity<GameModel> postGame(HttpServletRequest request, @RequestBody GameModel gameModel) {

        String token = jwtokenService.extractToken(request);
        Long userId = jwtokenService.getUserIdFromToken(token);

        gameModel.setGame_user_id(userId);
    GameModel gamePosted =  gameService.postGame(gameModel);
     return new ResponseEntity<>( gamePosted, HttpStatusCode.valueOf(200));
 }
    
    @PutMapping
    public ResponseEntity<GameModel> updateGame(@RequestBody GameModel gameModel) {
         GameModel gameUpdated =  gameService.upateGame(gameModel);
         return new ResponseEntity<>( gameUpdated, HttpStatusCode.valueOf(200));
     }


    @DeleteMapping
    public ResponseEntity<?> deleteGame(@RequestParam(value = "id") String gameId) {
         gameService.deleteGame(gameId);
        return new ResponseEntity<>( gameId, HttpStatusCode.valueOf(203));
    }
}
