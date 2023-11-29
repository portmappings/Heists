package me.portmapping.heist.gameplay.heists.events;

import me.portmapping.heist.gameplay.heists.builder.Heist;

public class HeistStartEvent extends HeistEvent{
    public HeistStartEvent(Heist heist){
        super(heist);
    }
}
