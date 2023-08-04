package de.bellobodo.manhunt1_20.manager.render;

import de.bellobodo.guilibrary.builder.SimpleGUIBuilder;
import de.bellobodo.guilibrary.guis.SimpleGUI;
import de.bellobodo.manhunt1_20.Manhunt1_20;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class HuntGUI {

    private final Manhunt1_20 instance;

    private SimpleGUI gui;

    public HuntGUI(Manhunt1_20 instance) {
        this.instance = instance;
    }

    public void openInventory(final Player player) {
        if (gui == null) {
                ArrayList<ItemStack> optionItems = new ArrayList<>();

                {
                    ItemStack itemStack = new ItemStack(Material.GREEN_CONCRETE);

                    ItemMeta itemMeta = itemStack.getItemMeta();

                    itemMeta.setDisplayName(ChatColor.GREEN + "Starten");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Startet Manhunt");

                    itemMeta.setLore(lore);

                    itemStack.setItemMeta(itemMeta);

                    optionItems.add(itemStack);
                }
                {
                    ItemStack itemStack = new ItemStack(Material.YELLOW_CONCRETE);

                    ItemMeta itemMeta = itemStack.getItemMeta();

                    itemMeta.setDisplayName(ChatColor.YELLOW + "Pausieren");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Pausiert Manhunt");

                    itemMeta.setLore(lore);

                    itemStack.setItemMeta(itemMeta);

                    optionItems.add(itemStack);
                }
                {
                    ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);

                    ItemMeta itemMeta = itemStack.getItemMeta();

                    itemMeta.setDisplayName(ChatColor.RED + "Stoppen");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "Stoppt Manhunt");

                    itemMeta.setLore(lore);

                    itemStack.setItemMeta(itemMeta);

                    optionItems.add(itemStack);
                }

                gui = new SimpleGUIBuilder().createSimpleGUI(optionItems, null, "Manhunt");
            }
        player.openInventory(gui.getGUIInventory());
    }

    public void inventoryClick(InventoryClickEvent event) {
        int result = gui.getInventoryClick(event);

        if (result == -1) return;

        Player player = Bukkit.getPlayer(event.getWhoClicked().getName());

        player.sendMessage(String.valueOf(result));
    }
}
