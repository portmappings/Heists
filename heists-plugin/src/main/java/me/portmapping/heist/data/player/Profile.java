package me.portmapping.heist.data.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.gameplay.crew.builder.CrewInvite;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public class Profile {
    private final UUID uuid;
    private int heists;
    private int failed_heists;
    private int money_delivered;
    private boolean crewChat;
    private UUID currentCrewID;
    private CrewInvite crewInvite;
}
