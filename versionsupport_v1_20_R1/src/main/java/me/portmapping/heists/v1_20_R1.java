package me.portmapping.heists;

import me.portmapping.heist.api.server.VersionSupport;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockChange;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R1.block.data.CraftBlockData;

public class v1_20_R1 extends VersionSupport {
    @Override
    public boolean placeWandSelectionTower(Location location) {

        return false;
    }
}