package me.portmapping.heist.gameplay.throwables.command;


import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Subcommand;


@Command("throwable")
public class ThrowableCommand {

    private final Heists instance = Heists.getInstance();

    @Subcommand("give")
    public void giveGun(Player sender, @Default("me") Player target, Throwable throwable){
        if(throwable == null){
            sender.sendMessage(CC.RED+"That throwable does not exists");
        }
        if(target==null){
            sender.sendMessage(Language.NOT_ONLINE);
        }
        sender.sendMessage(CC.GREEN+"You gave a "+throwable.getDisplayName()+" to "+target.getName());
        target.sendMessage(CC.GREEN+"You have received a "+throwable.getDisplayName());
        instance.getThrowableManager().giveThrowable(target,throwable);
    }
}
