package me.portmapping.heist.utils;

import me.portmapping.heist.gameplay.guns.builder.Gun;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public static boolean hasAmmo(Player player, Gun gun){
        Inventory playerInventory = player.getInventory();

        for (int slot = 0; slot < playerInventory.getSize(); slot++) {
            ItemStack item = playerInventory.getItem(slot);

            if (item != null && item.getType() == gun.getAmmoMaterial()) {
                int amount = item.getAmount();

                if (amount > 1) {
                    item.setAmount(amount - 1);
                    playerInventory.setItem(slot, item);
                } else {
                    playerInventory.setItem(slot, null);
                }

                player.updateInventory();
                return true;
            }
        }

        return false;
    }
}
