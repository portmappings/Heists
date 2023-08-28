package me.portmapping.heist.gameplay.crew.builder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public class Crew {
    private final UUID uuid = UUID.randomUUID();
    private Player owner;
    private List<Player> members = new ArrayList<>();
    private List<CrewInvite> inviteList = new ArrayList<>();

    public boolean isOwner(Player player){
        if(player.getUniqueId().equals(owner.getUniqueId())){
            return true;
        }
        return false;
    }

    public void sendMessage(String message){
        members.forEach(members -> members.sendMessage(message));
    }

}
