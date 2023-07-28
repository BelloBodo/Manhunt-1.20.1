package de.bellobodo.manhunt1_20.game;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GameCounter<T extends JavaPlugin> extends Counter {
    public GameCounter(T instance) {
        this.instance = instance;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void run() {
        //TODO Counter
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.sendMessage("GameCounter");
        });
    }
}
