package com.example.Games.Microservice.services;
import java.util.Base64;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;


@Service
public class JwtokenService {

  
    public String extractToken(HttpServletRequest request) {
        String Token = request.getHeader("Authorization");
 
        return Token;
    }


    public Long getUserIdFromToken(String token){
       String[] chunks = token.split("\\.");

       Base64.Decoder decoder = Base64.getUrlDecoder();
       String payloadJson = new String(decoder.decode(chunks[1]));

       JSONObject payload = new JSONObject(payloadJson);

       Long userId = payload.getLong("userId");

       return userId;
    }
}