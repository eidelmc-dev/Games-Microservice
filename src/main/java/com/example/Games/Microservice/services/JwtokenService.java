package com.example.Games.Microservice.services;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;


@Service
public interface  JwtokenService {
    public String extractToken(HttpServletRequest request);
    public Long getUserIdFromToken(String token);
}