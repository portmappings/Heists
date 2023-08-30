package me.portmapping.heist.gameplay.guns.manager;

import lombok.Getter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.guns.builder.type.AK47;
import me.portmapping.heist.gameplay.guns.builder.type.Deagle;
import me.portmapping.heist.utils.framework.Manager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Getter
public class GunManager extends Manager {

    private final Map<Player, Long> cooldowns = new HashMap<>();

    private final List<Gun> guns = new ArrayList<>();

    public GunManager(Heists instance){
       super(instance);
    }
    public void giveGun(Player player,Gun gun){


        player.getInventory().addItem(gun.toItemStack());


    }

    public Gun getGunByItem(ItemStack stack){

        for(Gun gun : guns){
            if(stack.isSimilar(gun.toItemStack())){
                return gun;
            }
        }
        return null;
    }


    public boolean hasAmmo(Player player, Gun gun){
        Inventory playerInventory = player.getInventory();

        for (int slot = 0; slot < playerInventory.getSize(); slot++) {
            ItemStack item = playerInventory.getItem(slot);

            if (item != null && item.getType() == gun.getAmmoMaterial()) {
                return true;
            }
        }

        return false;
    }
    public void removeAmmo(Player player, Gun gun, int i){
        Inventory playerInventory = player.getInventory();

        for (int slot = 0; slot < playerInventory.getSize(); slot++) {
            ItemStack item = playerInventory.getItem(slot);

            if (item != null && item.getType() == gun.getAmmoMaterial()) {
                int amount = item.getAmount();

                if (amount > 1) {
                    item.setAmount(amount - i);
                    playerInventory.setItem(slot, item);
                } else {
                    playerInventory.setItem(slot, null);
                }

                player.updateInventory();
                return;
            }
        }


    }

    public Gun getGunByName(String name){
        name = ChatColor.stripColor(name);

        for(Gun gun : guns){
            String throwname = ChatColor.stripColor(gun.getName());
            if(name.equalsIgnoreCase(throwname)){
                return gun;
            }
        }
        return null;

    }
    public boolean isOnCooldown(Player player,Gun gun) {
        if (cooldowns.containsKey(player)) {
            if(cooldowns.get(player)>System.currentTimeMillis()){
                return true;
            }
            return false;
        }
        return false;
    }

    public void setCooldown(Player player,Gun gun) {
        cooldowns.put(player, System.currentTimeMillis()+gun.getCooldown());

    }




}
