package me.portmapping.heist.gameplay.guns.builder.type;

import com.cryptomorin.xseries.XMaterial;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.guns.builder.GunType;
import me.portmapping.heist.utils.chat.CC;

public class AK47 extends Gun {


    public AK47() {
        super(CC.t("&bAK-47"),"AK-47", XMaterial.WOODEN_SHOVEL.parseMaterial(), 0, 2, XMaterial.IRON_NUGGET.parseMaterial(),25,100, GunType.AUTOMATIC,2000);
        this.getLore().add((CC.t("&7&m----------------")));
        this.getLore().add((CC.t("&eDamage: &f"+this.getDamage())));
        this.getLore().add((CC.t("&eRange: &f"+this.getRange())));
        this.getLore().add((CC.t("&eBullets/Second: &f"+this.getCooldown()/20)));
        this.getLore().add((CC.t("&7&m----------------")));
    }




}
