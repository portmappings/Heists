package me.portmapping.heist.gameplay.bank.menu;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.bank.build.BankTransactionLog;
import me.portmapping.heist.gameplay.bank.build.BankTransactionType;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import me.portmapping.heist.utils.menu.pagination.PaginatedMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTransactionLogsMenu  extends PaginatedMenu {

    private final Heists instance = Heists.getInstance();


    @Override
    public String getTitle(Player player){
        return CC.t("&4&lWithdrawals");
    }

    @Override
    public String getPrePaginatedTitle(Player player) {
        return "PREPAGINATED";
    }

    @Override
    public Map<Integer, Button> getAllPagesButtons(Player player) {
        Profile profile = instance.getPlayerManager().getProfile(player);
        Map<Integer, Button> buttonMap = new HashMap<>();
        int slot = 0;
        for(BankTransactionLog log : profile.getBankTransactionLogs()){
            buttonMap.put(slot,new BankTransactionLogButton(log));
            slot++;
        }
        return buttonMap;

    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*5;
    }


    @Override
    public int getMaxItemsPerPage(Player player) {
        return 13;
    }



    @RequiredArgsConstructor
    private class BankTransactionLogButton extends Button {

        private final BankTransactionLog log;

        @Override
        public ItemStack getButtonItem(Player p0) {

            ItemBuilder logItemBuilder = new ItemBuilder(Material.BOOK);
            switch (log.getTransactionType()){
                case DEPOSIT:
                    logItemBuilder.setName(CC.GREEN+"+"+CC.formatNumber(log.getAmount()));
                    break;
                case WITHDRAWAL:
                    logItemBuilder.setName(CC.RED+"-"+CC.formatNumber(log.getAmount()));
                    break;
            }
            List<String> loreList = new ArrayList<>();
            loreList.add(CC.t("&bDate: &f"+log.getDate().getDayOfMonth()+", "+log.getDate().getMonth().name()+", "+log.getDate().getYear()));
            loreList.add(CC.t("&bTime: &f"+log.getDate().getHour()+":"+log.getDate().getMinute()));
            logItemBuilder.setLore(loreList);
            return logItemBuilder.toItemStack();

        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType) {

        }

    }
}