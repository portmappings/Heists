package me.portmapping.heist.gameplay.guns.command;

import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Subcommand;

@Command("ammo")
public class AmmoCommand {
    @Subcommand("give")
    public void giveGun(Player sender, @Default("me") Player target, Gun gun, int amount){

        if(gun == null){
            sender.sendMessage(CC.RED+"That gun does not exists");
        }
        if(target==null){
            sender.sendMessage(Language.NOT_ONLINE);
        }
        sender.sendMessage(CC.GREEN+"You gave a "+gun.getName()+" to "+target.getName());
        target.sendMessage(CC.GREEN+"You have received a "+gun.getName());
        target.getInventory().addItem(new ItemStack(gun.getAmmoMaterial(),amount));
    }
}
