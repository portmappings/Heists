package me.portmapping.heist.gameplay.crew.manager;


import lombok.Getter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.builder.CrewInvite;
import me.portmapping.heist.gameplay.crew.menu.crew.CrewMenu;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class CrewManager {
    private final Heists instance;
    private final Map<UUID, Crew> crewMap = new HashMap<>();

    public CrewManager(Heists instance){
        this.instance = instance;
    }


    public Crew getCrew(Player player){
        Crew toReturn = null;
        Profile profile = instance.getPlayerManager().getProfile(player);
        for(Crew crew : crewMap.values()){
            if(crew.getUuid().equals(profile.getCurrentCrewID())){
               toReturn = crew;
            }
        }
        return toReturn;
    }

    public Crew createCrew(Player player){
        Crew crew = new Crew();
        Profile profile = instance.getPlayerManager().getProfile(player);
        crew.setOwner(player);
        profile.setCurrentCrewID(crew.getUuid());
        player.sendMessage(crew.getUuid());
        crew.getMembers().add(player);
        crewMap.put(crew.getUuid(),crew);
        return crew;
    }

    public void toggleCrewChat(Player player){
        Profile profile = instance.getPlayerManager().getProfile(player);

        if(getCrew(player)!=null){
            profile.setCrewChat(true);
            player.sendMessage(CC.GREEN+"Crew chat was enabled");
        }
    }

    public void openCrewMenu(Player player){

        Crew crew = instance.getCrewManager().getCrew(player);
        new CrewMenu(crew).openMenu(player);
    }

    public void joinToCrew(Crew crew, Player player){
        Profile profile = instance.getPlayerManager().getProfile(player);
        crew.getMembers().add(player);
        profile.setCurrentCrewID(crew.getUuid());
        player.sendMessage(CC.GREEN+"You joined to a crew!");
    }
    public void disbandCrew(Crew crew){
        for (Player members : crew.getMembers()){

            if(!crew.isOwner(members)){
                members.sendMessage(CC.RED+"The crew was disbanded by the leader");
            }

            Profile profile = instance.getPlayerManager().getProfile(members);
            profile.setCurrentCrewID(null);
        }


        for (CrewInvite crewInvite : crew.getInviteList()){

            Profile profile = instance.getPlayerManager().getProfile(crewInvite.getTarget());

            if(profile.getCurrentCrewID()==null){
                return;
            }

            //If the invite the player has is from the deleting crew, delete the invite
            if(profile.getCurrentCrewID().equals(crewInvite.getCrew().getUuid())){
                profile.setCurrentCrewID(null);
            }

        }
        crew.getMembers().clear();
        this.crewMap.remove(crew);
    }

    public void leaveCrew(Player player){
        Crew crew = instance.getCrewManager().getCrew(player);
        if(crew == null){
            player.sendMessage(Language.NO_CREW);
            return;
        }
        if(player.getUniqueId().equals(crew.getOwner().getUniqueId())){
            player.sendMessage(CC.RED+"You are the owner of this crew! You must disband");
            return;
        }
        crew.getMembers().remove(player);
        player.sendMessage(CC.GREEN+"You left to a crew!");
    }

    public void kickFromCrew(Crew crew, Player kicker,Player target){
        if(crew == null){
            kicker.sendMessage(Language.NO_CREW);
            return;
        }
        Profile profile = instance.getPlayerManager().getProfile(target);
        crew.getMembers().remove(target);
        target.sendMessage(CC.RED+"You were kicked from the crew");
        crew.sendMessage(CC.RED+target.getName()+" was kicked from the crew");
        profile.setCurrentCrewID(null);



    }

    public void inviteToCrew(Crew crew, Player sender,Player target){
        Profile targetProfile = instance.getPlayerManager().getProfile(target);
        Profile senderProfile = instance.getPlayerManager().getProfile(sender);
        if(target.getName().equalsIgnoreCase(sender.getName())){
            target.sendMessage(CC.RED+"You cannot invite yourself");
            return;
        }
        if(instance.getCrewManager().getCrew(target)!=null){
            sender.sendMessage(CC.RED+"This player is already in a crew");
            return;
        }
        for(CrewInvite crewInvite : crew.getInviteList()){
            if(crewInvite.getTarget().equals(target.getUniqueId())){
                sender.sendMessage(CC.RED+"You have already invited this player");
                return;
            }
        }
        CrewInvite crewInvite = new CrewInvite(sender.getUniqueId(),target.getUniqueId(),crew);
        crew.getInviteList().add(crewInvite);
        targetProfile.setCrewInvite(crewInvite);
        Bukkit.getScheduler().runTaskLater(Heists.getInstance(),()->{
            targetProfile.setCrewInvite(null);
        },5*60*20);
        sender.sendMessage(CC.GREEN+"You have invited "+target.getName()+" to the crew");
        target.sendMessage(CC.GREEN+"You were invited to "+sender.getName()+"'s party (You have 5 min to accept)");


    }
}
