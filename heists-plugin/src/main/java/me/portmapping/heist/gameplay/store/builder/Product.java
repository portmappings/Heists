package me.portmapping.heist.gameplay.store.builder;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crewmember.CrewMemberMenu;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@RequiredArgsConstructor
public class Product extends Button {

    private final int price;





    @Override
    public ItemStack getButtonItem(Player p0) {
        ItemBuilder itemBuilder = new ItemBuilder(Material.WOODEN_AXE);

        return itemBuilder.toItemStack();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType){
    }
}
