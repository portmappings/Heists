package me.portmapping.heist.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.StringJoiner;

@AllArgsConstructor
@Getter
@Setter
public class CustomLocation {

    private String world;

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    public CustomLocation(double x, double y, double z) {
        this(x, y, z, 0.0F, 0.0F);
    }

    public CustomLocation(String world, double x, double y, double z) {
        this(world, x, y, z, 0.0F, 0.0F);
    }

    public CustomLocation(double x, double y, double z, float yaw, float pitch) {
        this("world", x, y, z, yaw, pitch);
    }

    public static CustomLocation fromBukkitLocation(Location location) {
        return new CustomLocation(location.getWorld().getName(), location.getX(), location.getY(),
                location.getZ(), location.getYaw(), location.getPitch());
    }

    public static CustomLocation stringToLocation(String string) {
        String[] split = string.split(", ");

        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[1]);
        double z = Double.parseDouble(split[2]);

        CustomLocation customLocation = new CustomLocation(x, y, z,4f,4f);
        if (split.length == 4) {
            customLocation.setWorld(split[3]);
        } else if (split.length >= 5) {
            customLocation.setYaw(Float.parseFloat(split[3]));
            customLocation.setPitch(Float.parseFloat(split[4]));
            if (split.length >= 6) {
                customLocation.setWorld(split[5]);
            }
        }

        return customLocation;
    }

    public String toAString(){
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(Double.toString(this.getX()));
        joiner.add(Double.toString(this.getY()));
        joiner.add(Double.toString(this.getZ()));
        if (this.getYaw() == 0.0f && this.getPitch() == 0.0f) {
            if (this.getWorld().equals("world")) {
                return joiner.toString();
            } else {
                joiner.add(this.getWorld());
                return joiner.toString();
            }
        } else {
            joiner.add(Float.toString(this.getYaw()));
            joiner.add(Float.toString(this.getPitch()));
            if (this.getWorld().equals("world")) {
                return joiner.toString();
            } else {
                joiner.add(this.getWorld());
                return joiner.toString();
            }
        }
    }

    public World toBukkitWorld() {
        if (this.world == null) {
            return Bukkit.getServer().getWorlds().get(0);
        } else {
            return Bukkit.getServer().getWorld(this.world);
        }
    }

    public Location toBukkitLocation() {
        return new Location(this.toBukkitWorld(), this.x, this.y, this.z, this.yaw, this.pitch);
    }

}
