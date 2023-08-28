package me.portmapping.heist.data.player;

import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.framework.Manager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager extends Manager {

    public Map<UUID, Profile> profileMap = new HashMap<>();

    public PlayerManager(Heists instance) {
        super(instance);
    }

    public Profile getProfile(UUID uuid){
        if(profileMap.containsKey(uuid)){
            return profileMap.get(uuid);
        }else{
            return createProfile(uuid);
        }
    }

    public Profile getProfile(Player player){
        return getProfile(player.getUniqueId());
    }
    private Profile createProfile(UUID uuid){
        Profile profile = new Profile(uuid);
        //GATHER DB DATA PROCESS
        profileMap.put(uuid,profile);
        return profile;
    }
}
