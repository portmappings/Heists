package me.portmapping.heist.gameplay.store.manager;

import lombok.Getter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.gameplay.store.builder.type.ammunation.manager.AmmunationStoreManager;
import me.portmapping.heist.gameplay.store.enums.StoreStep;
import me.portmapping.heist.gameplay.wand.builder.Wand;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.file.FileConfig;
import me.portmapping.heist.utils.item.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

@Getter

public class StoreManager {

    private final Heists instance;
    private AmmunationStoreManager ammunationStoreManager;

    private Map<String, Store> storeList = new HashMap<>();
    public StoreManager(Heists instance){
        this.instance = instance;
        this.ammunationStoreManager = new AmmunationStoreManager(instance);

    }

    public boolean isStore(Location location){

        for(Store store : storeList.values()){
            if(store.getRegion().isIn(location)) {
                return true;
            }
        }
        return false;
    }
    public Store getStore(Location location){
        for(Store store : storeList.values()){
            if(store.getRegion().isIn(location)) {
                return store;
            }
        }
        return null;
    }




}
