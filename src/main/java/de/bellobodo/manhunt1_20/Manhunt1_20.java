package de.bellobodo.manhunt1_20;

import de.bellobodo.manhunt1_20.commands.ChangePlayerRoleCommand;
import de.bellobodo.manhunt1_20.commands.HuntCommand;
import de.bellobodo.manhunt1_20.game.GameManager;
import de.bellobodo.manhunt1_20.listeners.*;
import de.bellobodo.manhunt1_20.manager.player.PlayerManager;
import de.bellobodo.manhunt1_20.manager.render.HuntGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manhunt1_20 extends JavaPlugin {

    private static Manhunt1_20 instance;

    private GameManager gameManager;

    private PlayerManager playerManager;

    private HuntGUI huntGUI;

    @Override
    public void onLoad() {
        instance = this;
        this.saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        this.gameManager = new GameManager(instance);
        this.huntGUI = new HuntGUI(instance);
        this.playerManager = new PlayerManager(instance);

        Bukkit.getPluginManager().registerEvents(new GamemodeSwitchListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakPlaceListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new EntityMoveListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuitListener(instance), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(instance), this);

        this.getCommand("hunt").setExecutor(new HuntCommand(instance));
        this.getCommand("changeplayerrole").setExecutor(new ChangePlayerRoleCommand(instance));
    }

    @Override
    public void onDisable() {

    }

    public String getPrefix() {
        return ChatColor.DARK_GRAY + "[" + ChatColor.BOLD + ChatColor.AQUA.toString() + "Manhunt" + ChatColor.RESET + ChatColor.DARK_GRAY + "] ";
    }


    public HuntGUI getHuntGUI() {
        return huntGUI;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
