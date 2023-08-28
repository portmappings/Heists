package me.portmapping.heist.gameplay.crew.menu.crew.buttons;

import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.menu.crew.CrewMenu;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;



public class CrewChatButton extends Button {

    @Override
    public ItemStack getButtonItem(Player p0) {
        ItemBuilder itemBuilder = new ItemBuilder(Material.GREEN_DYE);
        itemBuilder.setName(CC.AQUA+"Crew Chat");
        List<String> toLore = new ArrayList<>();
        Profile profile = getInstance().getPlayerManager().getProfile(p0);
        if(profile.isCrewChat()){
            toLore.add(CC.GREEN+"Enabled");
        }else {
            toLore.add(CC.RED+"Disabled");
        }
        itemBuilder.setLore(toLore);
        return itemBuilder.toItemStack();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        Profile profile = getInstance().getPlayerManager().getProfile(player);
        profile.setCrewChat(!profile.isCrewChat());
        Menu crewMenu = new CrewMenu(getInstance().getCrewManager().getCrew(player));
        crewMenu.openMenu(player);
    }
}