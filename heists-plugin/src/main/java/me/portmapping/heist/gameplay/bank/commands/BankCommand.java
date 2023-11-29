package me.portmapping.heist.gameplay.bank.commands;

import me.portmapping.heist.gameplay.bank.menu.BankMenu;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;


public class BankCommand {
    @Command("bank")
    public void openBank(Player sender){

        Menu menu = new BankMenu();
        menu.open(sender);

    }
}
