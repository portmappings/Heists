package me.portmapping.heist.gameplay.store.menu;

import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewChatButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewMemberButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.EmptyCrewMemberButton;
import me.portmapping.heist.gameplay.guns.builder.type.AK47;
import me.portmapping.heist.gameplay.guns.builder.type.Deagle;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class GunShopMenu extends Menu {
    @Override
    public String getTitle(Player player){
        return CC.t("&4Crew");
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();



        //Util crew buttons - Start
        buttonMap.put(0, new AutomaticsShopButton());
        buttonMap.put(2, new PistolsShopButton());
        buttonMap.put(4, new ShotgunShopButton());
        buttonMap.put(6, new ExplosiveGunsShopButton());


        return buttonMap;
    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*1;
    }

    private class AutomaticsShopButton extends Button{
        @Override
        public ItemStack getButtonItem(Player p0) {
            ItemBuilder itemBuilder = new ItemBuilder(new AK47().toItemStack().getType());
            itemBuilder.setName(CC.AQUA+"Automatic Guns Shop");

            return itemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            player.closeInventory();
        }
    }

    private class PistolsShopButton extends Button{
        @Override
        public ItemStack getButtonItem(Player p0) {
            ItemBuilder itemBuilder = new ItemBuilder(new Deagle().toItemStack().getType());
            itemBuilder.setName(CC.AQUA+"Pistol Shop");

            return itemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            player.closeInventory();
        }
    }

    private class ShotgunShopButton extends Button{
        @Override
        public ItemStack getButtonItem(Player p0) {
            ItemBuilder itemBuilder = new ItemBuilder(new AK47().toItemStack().getType());
            itemBuilder.setName(CC.AQUA+"Shotgun Shop");

            return itemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            player.closeInventory();
        }
    }

    private class ExplosiveGunsShopButton extends Button{
        @Override
        public ItemStack getButtonItem(Player p0) {
            ItemBuilder itemBuilder = new ItemBuilder(new AK47().toItemStack().getType());
            itemBuilder.setName(CC.AQUA+"Explosive Guns Shop");

            return itemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            player.closeInventory();
        }
    }

}
