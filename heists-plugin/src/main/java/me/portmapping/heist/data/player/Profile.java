package me.portmapping.heist.data.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.gameplay.crew.builder.CrewInvite;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.store.enums.StoreStep;
import me.portmapping.heist.gameplay.wand.builder.Wand;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public class Profile {
    private final UUID uuid;
    private int heists;
    private int failedHeists;
    private int moneyDelivered;
    private boolean crewChat;
    private UUID currentCrewID;
    private Gun unlockedGuns;
    private CrewInvite crewInvite;
    private Wand wandSelection = new Wand();
}
