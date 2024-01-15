package com.example.Games.Microservice.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Games.Microservice.models.GameModel;


@Repository
public interface GameRepository  extends CrudRepository<GameModel , Long> {

    

    
}
