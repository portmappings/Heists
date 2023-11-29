package me.portmapping.heist.gameplay.bank.menu.buttons;

import me.portmapping.heist.Heists;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankProfileButton extends Button {


    @Override
    public ItemStack getButtonItem(Player p0) {
        Profile profile = Heists.getInstance().getPlayerManager().getProfile(p0);
        ItemBuilder profileItem = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(p0.getName());
        profileItem.setName(CC.t("&c&lBank Account"));
        profileItem.setLore(Arrays.asList(CC.t("&eUser: &f"+p0.getName()),CC.t("&eBalance: &f"+profile.getBankMoney())));
        return profileItem.toItemStack();

    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {

    }

}


