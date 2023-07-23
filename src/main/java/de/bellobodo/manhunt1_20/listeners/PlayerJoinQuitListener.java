package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    private final Manhunt1_20 instance;

    public PlayerJoinQuitListener(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Bukkit.getOnlinePlayers().stream().filter(players -> players != event.getPlayer()).forEach(players -> {
            players.sendMessage(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.DARK_GRAY +
                    " hat den Server " + ChatColor.GREEN +  " betreten" + ChatColor.DARK_GRAY + ".");
        });
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Bukkit.getOnlinePlayers().stream().filter(players -> players != event.getPlayer()).forEach(players -> {
            players.sendMessage(ChatColor.GRAY + event.getPlayer().getName() + ChatColor.DARK_GRAY +
                    " hat den Server " + ChatColor.RED +  " verlassen" + ChatColor.DARK_GRAY + ".");
        });
    }
}
