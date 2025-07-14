package com.soumyajit.Number_Guessing_Game.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GameService {

    private final int MAX_ATTEMPTS = 5;
    private int targetNumber = new Random().nextInt(100) + 1;
    private int attemptsLeft = MAX_ATTEMPTS;
    private int score = 0;

    public Map<String, Object> guessNumber(int guess) {
        Map<String, Object> response = new HashMap<>();

        if (attemptsLeft <= 0) {
            response.put("message", "No attempts left. Restart the game.");
            response.put("status", "fail");
            return response;
        }

        attemptsLeft--;

        if (guess == targetNumber) {
            score += (MAX_ATTEMPTS - attemptsLeft) * 10;
            response.put("message", "Correct! 🎉");
            response.put("status", "success");
            response.put("score", score);
        } else if (guess < targetNumber) {
            response.put("message", "Too low! ⬇️");
            response.put("status", "continue");
        } else {
            response.put("message", "Too high! ⬆️");
            response.put("status", "continue");
        }

        response.put("attemptsLeft", attemptsLeft);
        return response;
    }

    public Map<String, Object> restartGame() {
        targetNumber = new Random().nextInt(100) + 1;
        attemptsLeft = MAX_ATTEMPTS;
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Game restarted.");
        response.put("attemptsLeft", attemptsLeft);
        return response;
    }

    public Map<String, Object> getScore() {
        Map<String, Object> response = new HashMap<>();
        response.put("score", score);
        return response;
    }
}

