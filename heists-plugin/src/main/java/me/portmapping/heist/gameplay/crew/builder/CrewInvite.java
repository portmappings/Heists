package me.portmapping.heist.gameplay.crew.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class CrewInvite {
    private final UUID uuid = UUID.randomUUID();
    private final UUID sender;
    private final UUID target;
    private final Crew crew;
}
