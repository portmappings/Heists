package me.portmapping.heist.gameplay.crew.menu.crew.buttons;

import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class EmptyCrewMemberButton extends Button {


    public EmptyCrewMemberButton(){

    }


    @Override
    public ItemStack getButtonItem(Player p0) {
        ItemBuilder emptyButton = new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        emptyButton.setName(CC.AQUA+"Invite a player");
        return emptyButton.toItemStack();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        player.closeInventory();
        player.setMetadata("crew-invite", new FixedMetadataValue(getInstance(),"true"));
        player.sendMessage(CC.GREEN+"Type the name of the player to invite");
    }

}