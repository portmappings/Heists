package me.portmapping.heist.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class ParticleUtils {
    public static void spawnParticleLine(Location startingLocation, Particle toUse, Location toReach){
        World world = startingLocation.getWorld();
        //Add offset so particle line starts higher ~eye level
        Location loc = startingLocation.add(0,1,0);
        double distance = startingLocation.distance(toReach);
        double step = 0.1D;
        Vector line = startingLocation.getDirection();
        for (double d = 0; d <=  distance; d += step) {
            loc.add(line);
            world.spawnParticle(toUse, loc, 0);
        }
    }
    public static void spawnParticleLine(Location startingLocation, Particle toUse,int distance){
        World world = startingLocation.getWorld();
        //Add offset so particle line starts higher ~eye level
        Location loc = startingLocation.add(0,1,0);
        double step = 0.1D;
        Vector line = startingLocation.getDirection();
        for (double d = 0; d <=  distance; d += step) {
            loc.add(line);
            world.spawnParticle(toUse, loc, 0);
        }
    }
}
