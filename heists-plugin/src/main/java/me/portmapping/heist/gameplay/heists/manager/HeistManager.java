package me.portmapping.heist.gameplay.heists.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.gameplay.heists.builder.HeistState;
import me.portmapping.heist.gameplay.heists.builder.HeistType;
import me.portmapping.heist.gameplay.heists.task.HeistTask;
import me.portmapping.heist.utils.CustomLocation;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class HeistManager {

    private final Heists instance;
    private Map<UUID,Heist> heists = new HashMap<>();
    public HeistManager(Heists instance){
        this.instance = instance;
        this.registerAllHeists();
    }


    public void joinHeist(Heist heist, Player player){
        Profile profile = instance.getPlayerManager().getProfile(player);

        if(profile.getCurrentHeistId()!=null){
            player.sendMessage(CC.RED+"You are already in a heist.");
            return;
        }


        //HEISTS ARE ON DEFAULT JUST FOR 5 PERSONS
        if(heist.getPlayerList().size()==5){
            player.sendMessage(CC.RED+"This heist is full.");
            return;
        }

        if(heist.getState() == HeistState.ACTIVE){
            player.sendMessage(CC.RED+"This heist has already started.");
            return;
        }


        if(heist.getState() == HeistState.CLOSED || heist.getState() == HeistState.CLOSING){
            player.sendMessage(CC.RED+"This heist is currently closed.");
            return;
        }

        player.getInventory().clear();
        profile.setCurrentHeistId(heist.getUuid());
        player.teleport(heist.getLobbyLocation().toBukkitLocation());
        heist.getPlayerList().add(player);
        heist.sendMessage(CC.t(player.getName()+" has joined (&b"+heist.getPlayerList().size()+"&e/&b5&e)"));




    }

    public void abandonHeist(Heist heist, Player player){
        Profile profile = instance.getPlayerManager().getProfile(player);



        player.getInventory().clear();
        profile.setCurrentHeistId(null);
        heist.sendMessage(CC.t(player.getName()+" has left (&b"+(heist.getPlayerList().size()-1)+"&e/&b5&e)"));
        heist.getPlayerList().remove(player);

    }



    public Heist getHeist(UUID uuid){
        Heist toReturn = null;
        for(Heist heist : heists.values()){
            if(heist.getUuid()==uuid){
                toReturn = heist;
            }
        }
        return toReturn;
    }

    public Heist getHeist(Profile profile){
        return getHeist(profile.getCurrentHeistId());
    }
    public Heist getHeist(Player player){
        return getHeist(instance.getPlayerManager().getProfile(player));
    }

    public void registerHeist(Heist heist){
        this.heists.put(heist.getUuid(),heist);
        BukkitRunnable task = new HeistTask(heist,instance);
        task.runTaskTimer(instance,20L,20L);
    }

    public void registerAllHeists(){

        ConfigurationSection section = instance.getConfigManager().getHeistsConfig().getConfig().getConfigurationSection("HEISTS");
        if(section ==null){
            Bukkit.getLogger().warning("There are no heists to register.");
            return;
        }

        for(String key : section.getKeys(false)){
            String name = section.getString(key+".NAME");
            String displayName = section.getString(key+".DISPLAY-NAME");
            UUID uuid = UUID.randomUUID();
            HeistType type = HeistType.valueOf(section.getString(key+".TYPE"));
            CustomLocation lobbyLocation = CustomLocation.stringToLocation(section.getString(key+".LOBBY-LOCATION"));


            Heist heist = new Heist(name,displayName,uuid,type, lobbyLocation);

            this.registerHeist(heist);
        }

    }

}
