package me.portmapping.heist.gameplay.bank.menu.buttons;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.bank.menu.BankDepositMenu;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class BankDepositButton extends Button {


    @Override
    public ItemStack getButtonItem(Player p0) {
        Profile profile = Heists.getInstance().getPlayerManager().getProfile(p0);
        ItemBuilder profileItem = new ItemBuilder(Material.REDSTONE).setName(CC.RED+"Deposit");
        return profileItem.toItemStack();

    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        player.closeInventory();
        new BankDepositMenu().open(player);
    }

}
