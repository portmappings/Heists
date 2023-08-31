package me.portmapping.heist.gameplay.store.builder.type.ammunation.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.gameplay.store.builder.type.ammunation.AmmunationStore;
import me.portmapping.heist.gameplay.store.manager.StoreManager;
import me.portmapping.heist.gameplay.wand.builder.Wand;
import me.portmapping.heist.utils.Cuboid;
import me.portmapping.heist.utils.file.FileConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AmmunationStoreManager extends StoreManager {



    private Map<String, AmmunationStore> ammunationStoreMap = new HashMap<>();
    public AmmunationStoreManager(Heists instance){
        super(instance);


    }
    private void loadStore(FileConfig fileConfig){
        for(String path : fileConfig.getConfig().getConfigurationSection("STORE-LOCATION").getKeys(false)){
            String displayName = fileConfig.getConfig().getString(path+".DISPLAY-NAME");
            String name = fileConfig.getConfig().getString(path+".NAME");

            int x1 = fileConfig.getConfig().getInt(path+".CORNER1.X");
            int y1 = fileConfig.getConfig().getInt(path+".CORNER1.Y");
            int z1 = fileConfig.getConfig().getInt(path+".CORNER1.Z");

            int x2 = fileConfig.getConfig().getInt(path+".CORNER2.X");
            int y2 = fileConfig.getConfig().getInt(path+".CORNER2.Y");
            int z2 = fileConfig.getConfig().getInt(path+".CORNER2.Z");

            int clerkx = fileConfig.getConfig().getInt(path+".CLERK.X");
            int clerky = fileConfig.getConfig().getInt(path+".CLERK.Y");
            int clerkz = fileConfig.getConfig().getInt(path+".CLERK.Z");
            World world = Bukkit.getWorld(fileConfig.getConfig().getString(path+".WORLD"));


           
            Location location1 = null;
            Location location2 = null;
            Cuboid region = null;
            Location clerkLocation = null;
            try {
                location1 = new Location(world,x1,y1,z1);
                location2 = new Location(world,x2,y2,z2);
                region = new Cuboid(location1,location2);
                clerkLocation = new Location(world,clerkx,clerky,clerkz);

            }catch (NullPointerException e){
                Bukkit.getLogger().warning("The world of an ammunition store does not exists, please check");
            }
            AmmunationStore ammunationStore = new AmmunationStore(displayName,name,region,clerkLocation);

        }
    }

    public void createAmmunitionStore(String displayName, String name,Wand wandSelection){
        Cuboid region = new Cuboid(wandSelection.getCorner1(),wandSelection.getCorner2());
        AmmunationStore ammunationStore = new AmmunationStore(displayName, name, region);
        ammunationStoreMap.put(ammunationStore.getName(),ammunationStore);
    }


}
