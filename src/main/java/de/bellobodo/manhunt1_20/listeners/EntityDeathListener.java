package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import org.bukkit.event.Listener;

public class EntityDeathListener implements Listener {

    private final Manhunt1_20 instance;

    public EntityDeathListener(Manhunt1_20 instance) {
        this.instance = instance;
    }
}
