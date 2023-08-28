package me.portmapping.heist.gameplay.crew.menu.crew.buttons;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crewmember.CrewMemberMenu;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor

public class CrewMemberButton extends Button {
    private final Player target;
    private final Crew crew;
    private final boolean owner;





    @Override
    public ItemStack getButtonItem(Player p0) {
        ItemBuilder itemBuilder = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target.getName());


        return itemBuilder.toItemStack();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        if(!crew.isOwner(player)){
            return;
        }
        new CrewMemberMenu(crew,target).openMenu(player);
    }
}