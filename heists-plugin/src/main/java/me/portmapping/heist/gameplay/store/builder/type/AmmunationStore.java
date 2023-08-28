package me.portmapping.heist.gameplay.store.builder.type;

import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.utils.Cuboid;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class AmmunationStore extends Store {
    public AmmunationStore(Cuboid region, Location clerkLocation) {
        super(CC.t("&4Ammunation"), "Ammunation",region, clerkLocation);
    }
}
