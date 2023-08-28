package me.portmapping.heist.tasks;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class HeistTask extends BukkitRunnable {

    private final Heist heist;

    @Override
    public void run() {
        switch (heist.getState()){
            case STARTING:
                break;
        }
    }
}
