package me.portmapping.heist.gameplay.guns.listener;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class GunListener implements Listener {

    private final Heists instance = Heists.getInstance();


    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (player == null) {
            return;
        }
        if (item == null || item.getType() == Material.AIR) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {

            return;
        }

        if (instance.getGunManager().getGunByItem
                (item) == null) {

            return;
        }
        Gun gun = instance.getGunManager().getGunByItem(item);
        item.setDurability((short) 0);
        event.setCancelled(true);
        gun.shoot(player);


    }



}






