package me.portmapping.heist;



import me.portmapping.heist.gameplay.guns.manager.GunManager;

import java.util.UUID;


public class API implements me.portmapping.heist.api.Heists {


    @Override
    public GunManager getGunManager() {
        return Heists.getInstance().getGunManager();
    }
}
