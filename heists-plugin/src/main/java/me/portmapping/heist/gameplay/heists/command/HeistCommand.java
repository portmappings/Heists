package me.portmapping.heist.gameplay.heists.command;


import me.portmapping.heist.Heists;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Subcommand;


@Command("me/portmapping/heist")
public class HeistCommand {

    private final Heists instance = Heists.getInstance();

    @Subcommand("setup")
    public void giveGun(Player sender, @Default("Store") String heistName){

    }
}
