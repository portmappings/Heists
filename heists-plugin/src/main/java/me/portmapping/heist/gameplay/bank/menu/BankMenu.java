package me.portmapping.heist.gameplay.bank.menu;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.bank.menu.buttons.BankDepositButton;
import me.portmapping.heist.gameplay.bank.menu.buttons.BankProfileButton;
import me.portmapping.heist.gameplay.bank.menu.buttons.BankTransactionLogsButton;
import me.portmapping.heist.gameplay.bank.menu.buttons.BankWithdrawButton;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewChatButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewMemberButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.EmptyCrewMemberButton;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BankMenu extends Menu {

    private final Heists instance = Heists.getInstance();


    @Override
    public String getTitle(Player player){
        return CC.t("&4&lBank");
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        buttonMap.put(1,new BankDepositButton());
        buttonMap.put(13,new BankProfileButton());
        buttonMap.put(19,new BankWithdrawButton());
        buttonMap.put(20, new BankTransactionLogsButton());


        return buttonMap;
    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*4;
    }

}
