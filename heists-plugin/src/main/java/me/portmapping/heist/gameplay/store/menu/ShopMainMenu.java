package me.portmapping.heist.gameplay.store.menu;

import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.menu.crew.CrewMenu;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewChatButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewMemberButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.EmptyCrewMemberButton;
import me.portmapping.heist.gameplay.guns.builder.type.AK47;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopMainMenu extends Menu {

    @Override
    public String getTitle(Player player){
        return CC.RED+"Shop";
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();


        buttonMap.put(13+9+9, new CrewChatButton());


        return buttonMap;
    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*3;
    }


    private class GunShopButton extends Button{
        @Override
        public ItemStack getButtonItem(Player p0) {
            ItemBuilder itemBuilder = new ItemBuilder(new AK47().toItemStack().getType());
            itemBuilder.setName(CC.AQUA+"Guns Shop");

            return itemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            player.closeInventory();
        }
    }
}
