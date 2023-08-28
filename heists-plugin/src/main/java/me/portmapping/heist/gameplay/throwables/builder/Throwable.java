package me.portmapping.heist.gameplay.throwables.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.item.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class Throwable {
    private final String displayName;
    private final String name;
    private final Material material;
    private final int itemData;
    private final int radius;
    private final double speed;
    private final int timeToDetonate;
    private final int cooldown;
    private final List<String> lore = new ArrayList();
    public void explode(Location location){}
    public void onTick(Location location){}
    public void playerThrow(Player player){
        if(!Heists.getInstance().getThrowableManager().isOnCooldown(player,this)){
            Snowball snowball = player.launchProjectile(Snowball.class);
            snowball.setMetadata(this.getName(),new FixedMetadataValue(Heists.getInstance(),this.getName()));
            snowball.setVelocity(snowball.getVelocity().multiply(this.getSpeed()));
            Heists.getInstance().getThrowableManager().setCooldown(player,this);
        }

    }
    public ItemStack toItemStack(){
        ItemBuilder item = new ItemBuilder(material);

        item.setName(name);
        item.setDurability((short) itemData);
        item.setLore(lore);
        return item.toItemStack();
    }

}
