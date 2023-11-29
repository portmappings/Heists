package me.portmapping.heist.data.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.portmapping.heist.gameplay.bank.build.BankTransactionLog;
import me.portmapping.heist.gameplay.crew.builder.CrewInvite;
import me.portmapping.heist.gameplay.guns.builder.Gun;
import me.portmapping.heist.gameplay.wand.builder.Wand;

import java.util.ArrayList;
import java.util.List;
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
    private UUID currentHeistId;
    private Gun unlockedGuns;
    private CrewInvite crewInvite;
    private Wand wandSelection = new Wand();
    private int cash = 103034;
    private int bankMoney;
    private List<BankTransactionLog> bankTransactionLogs = new ArrayList<>();
}
