package me.portmapping.heist.gameplay.throwables.manager;

import lombok.Getter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.gameplay.throwables.builder.type.Grenade;
import me.portmapping.heist.gameplay.throwables.builder.type.SmokeGrenade;
import me.portmapping.heist.gameplay.throwables.builder.type.StunGrenade;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class ThrowableManager {

    private final Heists main;
    public ThrowableManager(Heists instance){
        main = instance;
        throwables.add(new Grenade());
        throwables.add(new StunGrenade());
        throwables.add(new SmokeGrenade());
    }
    private final Map<Player, Long> cooldowns = new HashMap<>();
    private final List<Throwable> throwables = new ArrayList();

    public void giveThrowable(Player player, Throwable throwable){


        player.getInventory().addItem(throwable.toItemStack());


    }

    public Throwable getThrowableByItem(ItemStack stack){

        for(Throwable throwable : throwables){
            if(stack.isSimilar(throwable.toItemStack())){
                return throwable;
            }
        }
        return null;
    }


    public Throwable getThrowableByName(String name){
        name = ChatColor.stripColor(name);

        for(Throwable throwable : throwables){
            String throwname = ChatColor.stripColor(throwable.getName());
            if(name.equalsIgnoreCase(throwname)){
                return throwable;
            }
        }
        return null;

    }

    public boolean isOnCooldown(Player player, Throwable throwable) {
        if (cooldowns.containsKey(player)) {
            if(cooldowns.get(player)>System.currentTimeMillis()){
                return true;
            }
            return false;
        }
        return false;
    }

    public void setCooldown(Player player,Throwable throwable) {
        cooldowns.put(player, System.currentTimeMillis()+throwable.getCooldown());

    }


}
