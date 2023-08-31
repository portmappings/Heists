package me.portmapping.heist.gameplay.store.builder;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.utils.Cuboid;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter

public abstract class Store {

    private final String displayName;
    private final String name;
    private final Cuboid region;
    private Location clerkLocation;
    private boolean closed;
    private Map<UUID, Player> insideStorePlayers;
    private Map<Integer, Product> productMap = new HashMap<>();

    public Store(String displayName, String name, Cuboid region) {
        this.displayName = displayName;
        this.name = name;
        this.region = region;
        this.clerkLocation = clerkLocation;


    }
    public Store(String displayName, String name, Cuboid region, Location clerkLocation) {
        this.displayName = displayName;
        this.name = name;
        this.region = region;
        this.clerkLocation = clerkLocation;


    }
}
