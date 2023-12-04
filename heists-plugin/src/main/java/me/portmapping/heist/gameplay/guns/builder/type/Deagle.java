package me.portmapping.heist.gameplay.guns.builder.type;

import com.cryptomorin.xseries.XMaterial;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.guns.builder.GunType;
import me.portmapping.heist.utils.chat.CC;

public class Deagle extends Gun {


    public Deagle() {
        super(CC.t("&bDesert Eagle"),"DesertEagle", XMaterial.IRON_SHOVEL.parseMaterial(), 0, 4, XMaterial.GOLD_NUGGET.parseMaterial(),30,1550, GunType.PISTOL,500);
        this.getLore().add((CC.t("&7&m----------------")));
        this.getLore().add((CC.t("&eDamage: &f"+this.getDamage())));
        this.getLore().add((CC.t("&eRange: &f"+this.getRange())));
        this.getLore().add((CC.t("&eBullets/Second: &f"+this.getCooldown()/20)));
        this.getLore().add((CC.t("&7&m----------------")));
    }




}
