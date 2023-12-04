package me.portmapping.heist.gameplay.store.command;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.store.menu.ShopMainMenu;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;


public class ShopCommand {

    private final Heists instance = Heists.getInstance();

    @Command("shop")
    public void wandGive(final Player sender){
        new ShopMainMenu().open(sender);
    }
}
