package de.bellobodo.manhunt1_20.commands;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import de.bellobodo.manhunt1_20.manager.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChangePlayerRoleCommand implements CommandExecutor {

    private final Manhunt1_20 instance;

    public ChangePlayerRoleCommand(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage(instance.getPrefix() + ChatColor.RED + "Du musst ein Spieler sein.");
            return true;
        }

        if (strings.length == 0 || strings.length >= 3) {
            sendUsage(player);
            return true;
        }

        PlayerManager playerManager = instance.getPlayerManager();

        switch (strings[0].toUpperCase()) {
            case "SPECTATOR" -> {
                if (strings.length == 2) {
                    if (strings[1] == "@a") {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            playerManager.addSpectator(players.getUniqueId());

                            players.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Spectator.");
                        });

                        player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Alle Spieler sind nun Spectator.");

                    }
                    try {
                        Player playerToChange = Bukkit.getPlayer(strings[1]);
                        playerManager.addSpectator(playerToChange.getUniqueId());

                        playerToChange.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Spectator.");
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.GREEN + " ist nun ein Spectator.");
                    } catch (Exception e) {
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.RED + " ist kein Spieler.");
                    }
                } else {
                    playerManager.addSpectator(player.getUniqueId());

                    player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Du bist nun ein Spectator.");
                }
            }
            case "SPEEDRUNNER" -> {
                if (strings.length == 2) {
                    if (strings[1] == "@a") {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            playerManager.addSpeedrunner(players.getUniqueId());

                            players.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Speedrunner.");
                        });

                        player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Alle Spieler sind nun Speedrunner.");

                    }
                    try {
                        Player playerToChange = Bukkit.getPlayer(strings[1]);
                        playerManager.addSpeedrunner(playerToChange.getUniqueId());

                        playerToChange.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Speedrunner.");
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.GREEN + " ist nun ein Speedrunner.");
                    } catch (Exception e) {
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.RED + " ist kein Spieler.");
                    }
                } else {
                    playerManager.addSpeedrunner(player.getUniqueId());

                    player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Du bist nun ein Speedrunner.");
                }
            }
            case "HUNTER" -> {
                if (strings.length == 2) {
                    if (strings[1] == "@a") {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            playerManager.removeSpeedrunner(players.getUniqueId());
                            playerManager.removeSpectator(players.getUniqueId());


                            players.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Hunter.");
                        });

                        player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Alle Spieler sind nun Hunter.");

                    }
                    try {
                        Player playerToChange = Bukkit.getPlayer(strings[1]);
                        playerManager.removeSpeedrunner(playerToChange.getUniqueId());
                        playerManager.removeSpectator(playerToChange.getUniqueId());

                        playerToChange.sendMessage(instance.getPrefix() + ChatColor.DARK_AQUA + "Du bist nun ein Hunter.");
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.GREEN + " ist nun ein Hunter.");
                    } catch (Exception e) {
                        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + strings[1] + ChatColor.RED + " ist kein Spieler.");
                    }
                } else {
                    playerManager.removeSpeedrunner(player.getUniqueId());
                    playerManager.removeSpectator(player.getUniqueId());

                    player.sendMessage(instance.getPrefix() + ChatColor.GREEN + "Du bist nun ein Hunter.");
                }
            }
        }
        return true;
    }

    private void sendUsage(Player player) {
        player.sendMessage(instance.getPrefix() + ChatColor.GRAY + "Verwende" + ChatColor.DARK_GRAY + ": "
                + ChatColor.BLUE + "/changeplayerrole <Spectator|Speedrunner|Hunter> [{Spielername}|@a]");
    }
}
