package me.portmapping.heist.gameplay.heists.builder.type;

import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.gameplay.heists.builder.HeistState;
import org.bukkit.entity.Player;

import java.util.List;

public class Store extends Heist {

    public Store(int timeToEnd, int timeElapsed, List<Player> playerList, HeistState state) {
        super(timeToEnd, timeElapsed, playerList, state);
    }
}
