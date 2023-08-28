package me.portmapping.heist.gameplay.throwables.builder.type;

import com.cryptomorin.xseries.XMaterial;
import com.cryptomorin.xseries.XSound;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StunGrenade extends Throwable {

    public StunGrenade() {
        super(CC.t("&bStun Grenade"),"StunGrenade", XMaterial.EGG.parseMaterial(), 0, 5, 0.5,3,3000);
    }

    @Override
    public void explode(Location location){
        location.getWorld().spawnParticle(Particle.EXPLOSION_HUGE,location,10);
        location.getWorld().playSound(location, XSound.BLOCK_ANVIL_LAND.parseSound(),1.9F,1.4F);
        location.getWorld().playSound(location, XSound.ENTITY_GENERIC_EXPLODE.parseSound(),1.9F,1.5F);
        for (Entity entity : location.getWorld().getNearbyEntities(location,this.getRadius()*3,this.getRadius()*3,this.getRadius()*3)){
            if(entity instanceof LivingEntity){
                if(location.distance(entity.getLocation())<this.getRadius()){
                    ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,7*20,0));
                    ((LivingEntity)entity).damage(4);
                }
            }
        }
    }
}
