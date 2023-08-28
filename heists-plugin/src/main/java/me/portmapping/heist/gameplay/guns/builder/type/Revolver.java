package me.portmapping.heist.gameplay.guns.builder.type;

import com.cryptomorin.xseries.XMaterial;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.utils.chat.CC;

public class Revolver extends Gun {


    public Revolver() {
        super(CC.t("&bRevolver"),"Revolver", XMaterial.IRON_SHOVEL.parseMaterial(), 0, 2, XMaterial.GOLD_NUGGET.parseMaterial(),20,2000);
        this.getLore().add((CC.t("&7&m----------------")));
        this.getLore().add((CC.t("&eDamage: &f"+this.getDamage())));
        this.getLore().add((CC.t("&eRange: &f"+this.getRange())));
        this.getLore().add((CC.t("&eBullets/Second: &f"+this.getCooldown()/20)));
        this.getLore().add((CC.t("&7&m----------------")));
    }




}
