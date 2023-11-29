package me.portmapping.heist.gameplay.store.command;

import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

@Command("heists")
public class ShopCommand {

    private final Heists instance = Heists.getInstance();

    @Subcommand("wand")
    public void wandGive(final Player sender){
        instance.getWandManager().giveWand(sender);
        sender.sendMessage(CC.GREEN+"You received a selecting wand");
    }
}
