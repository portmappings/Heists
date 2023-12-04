package me.portmapping.heist.gameplay.guns.builder;

import com.cryptomorin.xseries.XSound;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.utils.ParticleUtils;
import me.portmapping.heist.utils.item.ItemBuilder;
import org.bukkit.GameMode;
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
    private final GunType type;
    private final int price;

    public Gun(String displayName, String name, Material material,
               int itemData, double damage, Material ammoMaterial,
               int range, int cooldown, GunType type, int price) {
        this.displayName = displayName;
        this.name = name;
        this.material = material;
        this.itemData = itemData;
        this.damage = damage;
        this.ammoMaterial = ammoMaterial;
        this.range = range;
        this.cooldown = cooldown;
        this.type = type;
        this.price = price;

    }

    public ItemStack toItemStack(){
        ItemBuilder item = new ItemBuilder(material);

        item.setName(displayName);
        item.setDurability((short) itemData);
        item.setLore(lore);
        return item.toItemStack();
    }

    public boolean isGun(Gun gun){
        boolean toReturn = true;

        if(this.getDisplayName() == gun.getDisplayName()){
            toReturn = false;
        }

        if(this.getName() == gun.getName()){
            toReturn = false;
        }

        if(this.getMaterial() == gun.getMaterial()){
            toReturn = false;
        }

        if(this.getItemData() == gun.getItemData()){
            toReturn = false;
        }

        if(this.getDamage() == gun.getDamage()){
            toReturn = false;
        }
        if(this.getAmmoMaterial() == gun.getAmmoMaterial()){
            toReturn = false;
        }
        if(this.getRange() == gun.getRange()){
            toReturn = false;
        }
        if(this.getCooldown() == gun.getCooldown()){
            toReturn = false;
        }
        if(this.getType() == gun.getType()){
            toReturn = false;
        }
        if(this.getPrice() == gun.getPrice()){
            toReturn = false;
        }

        return toReturn;
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

        //Remove one bullet if player is not on creative
        if(player.getGameMode() != GameMode.CREATIVE){
            Heists.getInstance().getGunManager().removeAmmo(player,this,1);
        }




        if(result == null) {
            ParticleUtils.spawnParticleLine(player.getLocation(),particle,this.getRange());
            return;
        }
        Entity hit = result.getHitEntity();

        if(hit == null) {
            ParticleUtils.spawnParticleLine(player.getLocation(),particle,result.getHitBlock().getLocation());
            return;
        }

        if (hit instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) hit;

            if(!hit.isDead()){
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
}





