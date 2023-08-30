package me.portmapping.heist.gameplay.store.builder.type.ammunation;

import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.utils.Cuboid;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class AmmunationStore extends Store {
    public AmmunationStore(String displayName, String name, Cuboid region) {
        super(CC.t(displayName), name,region);

    }

}
