package de.bellobodo.manhunt1_20.manager.player;

import de.bellobodo.manhunt1_20.Manhunt1_20;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerManager {

    private final Manhunt1_20 instance;

    public PlayerManager(Manhunt1_20 instance) {
        this.instance = instance;
    }

    private final ArrayList<Speedrunner> speedrunners = new ArrayList<>();

    private final ArrayList<UUID> spectators = new ArrayList<>();

    public boolean addSpeedrunner(UUID uuid) {
        boolean speedrunnerAlreadyExists = false;
        for (Speedrunner speedrunner : speedrunners) {
            if (speedrunner.getUUID() == uuid) {
                speedrunnerAlreadyExists = true;
                break;
            }
        }

        if (!speedrunnerAlreadyExists) {
            speedrunners.add(new Speedrunner(uuid));
            return true;
        }
        return false;
    }

    public boolean removeSpeedrunner(UUID uuid) {
        int speedrunnerExistsIndex = -1; // Initialwert für den Index des gefundenen Eintrags
        for (int i = 0; i < speedrunners.size(); i++) {
            Speedrunner speedrunner = speedrunners.get(i);
            if (speedrunner.getUUID() == uuid) {
                speedrunnerExistsIndex = i;
                break;
            }
        }

        if (speedrunnerExistsIndex != -1) {
            speedrunners.remove(speedrunnerExistsIndex);
            return true;
        }
        return false;
    }

    public void updateSpeedrunners() {
        for (Speedrunner speedrunner : speedrunners) {
            speedrunner.updateLocation();
        }
    }

    public boolean isSpeedrunner(UUID uuid) {
        boolean uuidIsSpeedrunner = false;
        for (Speedrunner speedrunner : speedrunners) {
            if (speedrunner.getUUID() == uuid) {
                uuidIsSpeedrunner = true;
                break;
            }
        }

        return uuidIsSpeedrunner;
    }

    public boolean isSpectator(UUID uuid) {
        return spectators.contains(uuid);
    }

    public boolean isHunter(UUID uuid) {
        return !isSpeedrunner(uuid) && !isSpectator(uuid);
    }


}
