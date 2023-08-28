package me.portmapping.heist.gameplay.throwables.builder.type;

import com.cryptomorin.xseries.XMaterial;
import com.cryptomorin.xseries.XSound;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Location;
import org.bukkit.Particle;

public class SmokeGrenade extends Throwable {

    public SmokeGrenade() {
        super(CC.t("&2Smoke Grenade"),"SmokeGrenade", XMaterial.SNOWBALL.parseMaterial(), 0, 3, 0.3,12,7000);
    }

    @Override
    public void explode(Location location){
        location.getWorld().playSound(location, XSound.ENTITY_CHICKEN_EGG.parseSound(),1F,1F);
    }

    @Override
    public void onTick(Location location){

        for(double phi=0; phi<=Math.PI; phi+=Math.PI/15) {
            for(double theta=0; theta<=2*Math.PI; theta+=Math.PI/30) {
                double r = 1.5;
                double x = r*Math.cos(theta)*Math.sin(phi);
                double y = r*Math.cos(phi) + 1.5;
                double z = r*Math.sin(theta)*Math.sin(phi);

                location.add(x,y,z);
                location.getWorld().spawnParticle(Particle.CLOUD, location, 1, 0F, 0F, 0F, 0.001);
                location.subtract(x, y, z);
            }
        }

    }
}
