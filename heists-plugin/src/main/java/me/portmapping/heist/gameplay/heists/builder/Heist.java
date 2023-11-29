package me.portmapping.heist.gameplay.heists.builder;

import lombok.*;
import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.CustomLocation;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
public  class Heist {
    private String name;
    private String displayName;
    private UUID uuid;
    private HeistType type;
    private CustomLocation lobbyLocation;


    @Setter(AccessLevel.MODULE)
    private int maxPlayers = 5;
    private boolean policeAlerted = false;
    private HeistState state = HeistState.WAITING;
    private int timeToEnd = 0;
    private int timeElapsed = 0;
    private int timeToStart = 12;
    private List<Player> playerList = new ArrayList<>();


    public Heist(String name, String displayName, UUID uuid, HeistType type, CustomLocation lobbyLocation) {
        this.name = name;
        this.displayName = displayName;
        this.uuid = uuid;
        this.type = type;
        this.lobbyLocation = lobbyLocation;
    }

    public void sendMessage(String message){
        playerList.forEach(player -> player.sendMessage(message));
    }
    public void sendTitle(String title, String subtitle){
        playerList.forEach(player -> player.sendTitle(title,subtitle,16,50,16));
    }


    public void sendTitle(String title){
        playerList.forEach(player -> player.sendTitle(title,"",16,50,16));
    }

    public void alertPolice(Player who){
        this.setPoliceAlerted(true);
        this.sendTitle(CC.RED+"The cops were alerted", CC.WHITE+"by: "+who.getName());
    }



}
