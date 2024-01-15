package com.example.Games.Microservice.models;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "game")
@jakarta.persistence.Entity
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long game_id;
    private Long game_user_id;
    private Long game_score;
    private Long game_level;
    private LocalDateTime game_update;
}
