package me.portmapping.heist.gameplay.wand.listener;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WandListener implements Listener{

    private final Heists instance = Heists.getInstance();
    @EventHandler
    public void wandSelect(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Action action = event.getAction();
        if(block==null){
            return;
        }
        if(player==null){
            return;
        }
        Profile profile = instance.getPlayerManager().getProfile(player);
        switch (action){
            case LEFT_CLICK_BLOCK -> {
                profile.getWandSelection().setCorner1(block.getLocation());
                player.sendMessage(CC.GREEN+"Selected pos1 at "+block.getX()+", "+block.getY()+", "+block.getZ());
            }
            case RIGHT_CLICK_BLOCK -> {
                profile.getWandSelection().setCorner2(block.getLocation());
                player.sendMessage(CC.GREEN+"Selected pos2 at "+block.getX()+", "+block.getY()+", "+block.getZ());

            }

        }
    }

}
