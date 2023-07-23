package de.bellobodo.manhunt1_20.game;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import de.bellobodo.manhunt1_20.manager.player.PlayerManager;

public class GameManager {

    private final Manhunt1_20 instance;

    private PlayerManager playerManager;

    public GameManager(Manhunt1_20 instance) {
        this.instance = instance;

        playerManager = new PlayerManager(instance);

        gameCounter = new GameCounter(instance);
        gameCounter.startCounter(); //TODO Delete
    }

    private GameCounter gameCounter;

    private GameState gameState = GameState.PENDING;


}
