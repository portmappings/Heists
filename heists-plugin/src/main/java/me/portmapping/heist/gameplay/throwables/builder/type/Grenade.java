package me.portmapping.heist.gameplay.throwables.builder.type;

import com.cryptomorin.xseries.XMaterial;
import me.portmapping.heist.gameplay.throwables.builder.Throwable;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Location;

public class Grenade extends Throwable {

    public Grenade() {
        super(CC.t("&2Grenade"),"Grenade", XMaterial.SNOWBALL.parseMaterial(), 0, 3, 0.3,5,2000);
    }

    @Override
    public void explode(Location location){
        location.getWorld().createExplosion(location,getRadius(),true);
    }
}
