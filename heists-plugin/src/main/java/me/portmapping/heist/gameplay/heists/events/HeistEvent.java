package me.portmapping.heist.gameplay.heists.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@Getter
public class HeistEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Heist match;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
}
