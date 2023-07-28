package de.bellobodo.manhunt1_20.commands;

import de.bellobodo.manhunt1_20.Manhunt1_20;
import de.bellobodo.manhunt1_20.manager.render.HuntGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HuntCommand implements CommandExecutor {

    private final Manhunt1_20 instance;

    public HuntCommand(Manhunt1_20 instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player player)) return true;

        instance.getHuntGUI().openInventory(player);

        return true;
    }
}
