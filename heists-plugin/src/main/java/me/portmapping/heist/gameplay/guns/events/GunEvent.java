package me.portmapping.heist.gameplay.guns.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


@RequiredArgsConstructor
@Getter
public class GunEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Gun gun;
    private final Player who;

    public static HandlerList getHandlerList(){return HANDLERS;}

    @Override
    public HandlerList getHandlers() {return HANDLERS;}
}
