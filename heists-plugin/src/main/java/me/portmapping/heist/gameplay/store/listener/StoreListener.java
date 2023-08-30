package me.portmapping.heist.gameplay.store.listener;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class StoreListener implements Listener {
    private final Heists instance = Heists.getInstance();
    @EventHandler
    private void onMoveEvent(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location to = event.getTo();
        Location from = event.getFrom();
        if(player == null){
            return;
        }
        if(to==from){
            return;
        }

        //CHECK IF THE LOCATION IS THE LOCATION OF A STORE
        if(!instance.getStoreManager().isStore(event.getTo())){
            return;
        }

    }

    @EventHandler
    private void claimStoreEvent(){

    }

    private void handleStoreEnter(PlayerMoveEvent event){
        Location from = event.getFrom();
        Location to = event.getTo();

        if (from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ()) {
            return;
        }

        Player player = event.getPlayer();
        boolean cancelled = false;

        Store store = Heists.getInstance().getStoreManager().getStore(to);

        if(store == null) {
            return;
        }


        if (cancelled) {
            from.setX(from.getBlockX() + 0.5);
            from.setZ(from.getBlockZ() + 0.5);
            event.setTo(from);
        }
    }


}
