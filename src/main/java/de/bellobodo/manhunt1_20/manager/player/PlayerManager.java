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
        for (Speedrunner speedrunner : this.speedrunners) {
            if (speedrunner.getUUID() == uuid) {
                speedrunnerAlreadyExists = true;
                break;
            }
        }

        if (!speedrunnerAlreadyExists) {
            this.speedrunners.add(new Speedrunner(uuid));

            removeSpectator(uuid);

            return true;
        }
        return false;
    }

    public boolean removeSpeedrunner(UUID uuid) {
        int speedrunnerExistsIndex = -1; // Initialwert für den Index des gefundenen Eintrags
        for (int i = 0; i < this.speedrunners.size(); i++) {
            Speedrunner speedrunner = this.speedrunners.get(i);
            if (speedrunner.getUUID() == uuid) {
                speedrunnerExistsIndex = i;
                break;
            }
        }

        if (speedrunnerExistsIndex != -1) {
            this.speedrunners.remove(speedrunnerExistsIndex);
            return true;
        }
        return false;
    }

    public void updateSpeedrunners() {
        for (Speedrunner speedrunner : this.speedrunners) {
            speedrunner.updateLocation();
        }
    }

    public boolean isSpeedrunner(UUID uuid) {
        boolean uuidIsSpeedrunner = false;
        for (Speedrunner speedrunner : this.speedrunners) {
            if (speedrunner.getUUID() == uuid) {
                uuidIsSpeedrunner = true;
                break;
            }
        }

        return uuidIsSpeedrunner;
    }

    public boolean addSpectator(UUID uuid) {
        if (this.spectators.add(uuid)) {
            removeSpeedrunner(uuid);
            return true;
        }
        return false;
    }

    public boolean removeSpectator(UUID uuid) {
        return this.spectators.remove(uuid);
    }


    public boolean isSpectator(UUID uuid) {
        return this.spectators.contains(uuid);
    }

    public boolean isHunter(UUID uuid) {
        return !isSpeedrunner(uuid) && !isSpectator(uuid);
    }


}
