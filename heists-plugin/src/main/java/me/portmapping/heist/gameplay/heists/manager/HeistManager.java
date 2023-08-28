package me.portmapping.heist.gameplay.heists.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.heists.builder.Heist;

import java.util.ArrayList;
import java.util.List;

public class HeistManager {

    private final Heists instance;
    private List<Heist> heists = new ArrayList<>();
    public HeistManager(Heists instance){
        this.instance = instance;
    }
    public void setup(Heist heist){

    }

}
