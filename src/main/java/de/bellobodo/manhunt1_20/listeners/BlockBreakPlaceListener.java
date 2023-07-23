package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakPlaceListener implements Listener {

    private final Manhunt1_20 instance;

    public BlockBreakPlaceListener(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (!event.getPlayer().hasPermission("Manhunt.break")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (!event.getPlayer().hasPermission("Manhunt.place")) {
            event.setCancelled(true);
        }
    }
}
