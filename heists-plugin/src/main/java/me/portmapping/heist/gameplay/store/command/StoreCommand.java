package me.portmapping.heist.gameplay.store.command;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.store.builder.Store;
import me.portmapping.heist.gameplay.store.builder.type.ammunation.AmmunationStore;
import me.portmapping.heist.gameplay.store.enums.StoreType;
import me.portmapping.heist.gameplay.wand.builder.Wand;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.annotation.Subcommand;

@Command("store")
public class StoreCommand {
    @Dependency
    private Heists instance;

    @Subcommand("create")
    public void storeCreate(final Player sender, StoreType storeType, String displayName, String name){

        Profile profile = instance.getPlayerManager().getProfile(sender);
        Wand wandSelection = profile.getWandSelection();
        if(wandSelection.getCorner1() == null || wandSelection.getCorner2() == null){
            sender.sendMessage(CC.RED+"First select the region of the store");
            return;
        }

    }
}
