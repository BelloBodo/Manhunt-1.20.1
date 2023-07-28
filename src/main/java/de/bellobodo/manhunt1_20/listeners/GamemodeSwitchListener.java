package de.bellobodo.manhunt1_20.listeners;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.sql.Array;
import java.util.ArrayList;

public class GamemodeSwitchListener implements Listener {


    private final Manhunt1_20 instance;

    public GamemodeSwitchListener(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onGamemodeSwitch(PlayerGameModeChangeEvent event) {
        if (instance.getPlayerManager().isHunter(event.getPlayer().getUniqueId())) {
            event.getPlayer().sendMessage();
            TextComponent baseText1 = new TextComponent(instance.getPrefix() + ChatColor.RED
                    + "Du musst ein Spectator oder Hunter sein um den Gamemode switchen zu können: ");


            TextComponent switchToSpectator = new TextComponent(ChatColor.GOLD + "SPECTATOR");
            switchToSpectator.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.GOLD + "Ändere deine Spielrolle zu Spectator.")));
            switchToSpectator.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/changeplayerrole SPECTATOR"));

            baseText1.addExtra(switchToSpectator);

            event.getPlayer().spigot().sendMessage(baseText1);

            event.setCancelled(true);
        }
    }
}
