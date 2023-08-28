package me.portmapping.heist.gameplay.heists.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public abstract class Heist {
    private int timeToEnd;
    private int timeElapsed;
    private List<Player> playerList;
    private HeistState state;



}
