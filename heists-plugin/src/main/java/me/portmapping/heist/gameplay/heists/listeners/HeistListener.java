package me.portmapping.heist.gameplay.heists.listeners;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.guns.events.GunFireEvent;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.gameplay.heists.builder.HeistState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HeistListener implements Listener {

    private final Heists instance = Heists.getInstance();
    @EventHandler
    public void onGunShoot(GunFireEvent event){
        Gun gun = event.getGun();
        Player player = event.getWho();
        Heist heist = instance.getHeistManager().getHeist(player);

        if(heist == null){
            return;
        }

        if(heist.getState() == HeistState.ACTIVE && !heist.isPoliceAlerted()){
            heist.alertPolice(player);

        }
    }
}
