package me.portmapping.heist.gameplay.bank.menu;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class BankDepositMenu extends Menu {

    private final Heists instance = Heists.getInstance();


    @Override
    public String getTitle(Player player){
        return CC.t("&4&lDeposit");
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        buttonMap.put(12,new BankDepositButton(50));
        buttonMap.put(12+9,new BankDepositButton(500));
        buttonMap.put(12+9+9,new BankDepositButton(2500));

        buttonMap.put(14,new BankDepositButton(10000));
        buttonMap.put(14+9,new BankDepositButton(100000));
        buttonMap.put(14+9+9,new BankDepositButton(1000000));

        return buttonMap;
    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*5;
    }




    @RequiredArgsConstructor
    private class BankDepositButton extends Button {

        private final int amount;

        @Override
        public ItemStack getButtonItem(Player p0) {

            ItemBuilder profileItem = new ItemBuilder(Material.EMERALD).setName(CC.RED+"Deposit $"+CC.formatNumber(amount));
            return profileItem.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {
            instance.getBankManager().deposit(player,amount);
            new BankDepositMenu().open(player);



        }

    }
}



