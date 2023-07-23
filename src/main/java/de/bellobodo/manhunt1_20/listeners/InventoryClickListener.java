package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final Manhunt1_20 instance;

    public InventoryClickListener(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

    }
}
