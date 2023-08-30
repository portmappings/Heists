package me.portmapping.heist.gameplay.wand.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;

@Getter
@Setter

public class Wand {
    private Location corner1;
    private Location corner2;
    private boolean done;
    public Wand(){

    }

}
