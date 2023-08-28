package me.portmapping.heist.gameplay.crew.menu.crewmember.buttons;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crew.CrewMenu;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.file.Callback;
import me.portmapping.heist.utils.item.ItemBuilder;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import me.portmapping.heist.utils.menu.menus.ConfirmMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class KickCrewMemberButton extends Button {


    private final Player target;
    private final Crew crew;


    @Override
    public ItemStack getButtonItem(Player p0) {
        ItemBuilder item = new ItemBuilder(Material.BARRIER);
        item.setName(CC.DARK_RED+"Kick "+ target.getName());
        return item.toItemStack();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType) {
        if(this.target == null){
            return;
        }
        if(!this.target.isOnline()){
            return;
        }
        Profile profile = getInstance().getPlayerManager().getProfile(this.target);
        if(profile.getCurrentCrewID().equals(this.crew.getUuid())){
            new ConfirmMenu(CC.GREEN+"Are you sure??", new Callback<Boolean>() {
                @Override
                public void callback(Boolean b) {
                    if(b){
                        getInstance().getCrewManager().kickFromCrew(crew,player,target);
                        Menu menu = new CrewMenu(crew);
                        menu.openMenu(player);
                    }
                }
            },true,this).openMenu(player);
        }

    }

}