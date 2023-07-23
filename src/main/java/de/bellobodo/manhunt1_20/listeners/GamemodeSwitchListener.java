package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GamemodeSwitchListener implements Listener {


    private final Manhunt1_20 instance;

    public GamemodeSwitchListener(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onGamemodeSwitch(PlayerGameModeChangeEvent event) {
        GameMode previousGamemode = event.getPlayer().getGameMode();
        GameMode newGamemode = event.getNewGameMode();

        if ((previousGamemode == GameMode.SURVIVAL || previousGamemode == GameMode.ADVENTURE)
        && newGamemode == GameMode.CREATIVE || newGamemode == GameMode.SPECTATOR) {
            event.getPlayer().sendMessage(instance.getPrefix() + ...); //TODO Sende dem Spieler eine Nachricht in der er erst in den Spectator Modus gehen muss.[Klickbar]
            event.setCancelled(true);
        }
    }
}
