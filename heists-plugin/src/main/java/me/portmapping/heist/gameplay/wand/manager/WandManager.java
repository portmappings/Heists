package me.portmapping.heist.gameplay.wand.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.framework.Manager;
import me.portmapping.heist.utils.item.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WandManager extends Manager {
    private ItemStack wandItem = new ItemBuilder(Material.WOOD_AXE).setName(CC.RED+"Wand").toItemStack();
    public WandManager(Heists instance) {
        super(instance);
    }
    public void giveWand(Player player){
        player.getInventory().addItem(wandItem);

    }

    public void removeWand(Player player){
        player.getInventory().remove(wandItem);
    }


}
