package com.soumyajit.Number_Guessing_Game.Controller;

import com.soumyajit.Number_Guessing_Game.Service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;



    @PostMapping("/guess")
    public Map<String, Object> guess(@RequestParam int guess) {
        return gameService.guessNumber(guess);
    }

    @PostMapping("/restart")
    public Map<String, Object> restart() {
        return gameService.restartGame();
    }

    @GetMapping("/score")
    public Map<String, Object> score() {
        return gameService.getScore();
    }
}
