package me.portmapping.heist.gameplay.store.builder;

import com.sun.jna.platform.unix.solaris.LibKstat;
import lombok.RequiredArgsConstructor;
import me.portmapping.heist.utils.Cuboid;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public abstract class Store {

    private final String displayName;
    private final String name;
    private final Cuboid region;
    private final Location clerkLocation;
    private boolean closed;
    private Map<Integer, Product> productMap = new HashMap<>();

}
