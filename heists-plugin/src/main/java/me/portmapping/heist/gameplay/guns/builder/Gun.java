package me.portmapping.heist.gameplay.guns.builder;

import com.cryptomorin.xseries.XSound;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.ParticleUtils;
import me.portmapping.heist.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public abstract class Gun {
    private final String displayName;
    private final String name;
    private final Material material;
    private final int itemData;
    private final double damage;
    private final Material ammoMaterial;
    private final int range;
    private final List<String> lore = new ArrayList<>();

    private final int cooldown;






    public ItemStack toItemStack(){
        ItemBuilder item = new ItemBuilder(material);

        item.setName(displayName);
        item.setDurability((short) itemData);
        item.setLore(lore);
        return item.toItemStack();
    }

    public void shoot(Player player){
        if(Heists.getInstance().getGunManager().isOnCooldown(player,this)){
            return;
        }

        Heists.getInstance().getGunManager().setCooldown(player,this);

        if(!Heists.getInstance().getGunManager().hasAmmo(player,this)){
            player.playSound(player.getLocation(), XSound.BLOCK_NOTE_BLOCK_HAT.parseSound(), 1F, 2);
            return;
        }


        Particle particle = Particle.SMOKE_NORMAL;
        RayTraceResult result = player.getWorld().rayTraceEntities(player.getEyeLocation().add(player.getEyeLocation().getDirection()),player.getEyeLocation().getDirection(),this.getRange());
        player.playSound(player.getLocation(), XSound.ENTITY_GENERIC_EXPLODE.parseSound(),1F,2.4F);

        Entity hit = result.getHitEntity();

        if(result == null) {
            ParticleUtils.spawnParticleLine(player.getLocation(),particle,this.getRange());
            return;
        }

        if(hit == null) {
            ParticleUtils.spawnParticleLine(player.getLocation(),particle,result.getHitBlock().getLocation());
            return;
        }

        if (hit instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) hit;

            //Storing the entity's original damage ticks to insert them back after removing them
            int damageTicks = livingEntity.getNoDamageTicks();
            livingEntity.setNoDamageTicks(0);
            livingEntity.damage(this.getDamage());
            player.playSound(player.getLocation(),XSound.ENTITY_EXPERIENCE_ORB_PICKUP.parseSound(),1F,1.5F);
            livingEntity.setNoDamageTicks(damageTicks);


            ParticleUtils.spawnParticleLine(player.getLocation(), particle, hit.getLocation());
        }

    }
}





