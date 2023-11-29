package me.portmapping.heist.gameplay.guns.events;

import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import org.bukkit.entity.Player;

public class GunFireEvent extends GunEvent{

    public GunFireEvent(Gun gun, Player who) {
        super(gun, who);
    }
}
