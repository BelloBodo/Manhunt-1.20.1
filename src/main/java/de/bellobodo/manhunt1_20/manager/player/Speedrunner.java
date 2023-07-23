package de.bellobodo.manhunt1_20.manager.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Speedrunner {

    private final UUID uuid;

    public Speedrunner(UUID uuid) {
        this.uuid = uuid;
    }

    private Location overworldLocation;
    private Location netherLocation;
    private Location endLocation;
    private Location customLocation;

    public void updateLocation() {
        Player player = Bukkit.getPlayer(uuid);

        if (player != null)  {
            Location location = player.getLocation();

            switch (location.getWorld().getEnvironment()) {
                case NORMAL -> this.overworldLocation = location;
                case NETHER -> this.netherLocation = location;
                case THE_END -> this.endLocation = location;
                case CUSTOM -> this.customLocation = location;
            }
        }
    }

    public UUID getUUID() {
        return uuid;
    }
}
