package me.portmapping.heist.gameplay.crew.command;


import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.builder.CrewInvite;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

@Command("crew")
public class CrewCommand {

    private final Heists instance = Heists.getInstance();



    @Subcommand("menu")
    public void crewMenu(Player sender){

        if(instance.getCrewManager().getCrew(sender)==null) {
            instance.getCrewManager().createCrew(sender);
        }
        instance.getCrewManager().openCrewMenu(sender);


    }
    @Subcommand("accept")
    public void acceptCrew(final Player sender){
        if(instance.getCrewManager().getCrew(sender)!=null){
            sender.sendMessage(CC.RED+"You are already in a crew");
            return;
        }
        Profile profile = instance.getPlayerManager().getProfile(sender);
        CrewInvite crewInvite = profile.getCrewInvite();
        if(crewInvite== null){
            sender.sendMessage(CC.RED+"You don't have any invite or it expired");
            return;
        }
        instance.getCrewManager().joinToCrew(crewInvite.getCrew(),sender);
        crewInvite.getCrew().getInviteList().remove(crewInvite);
        profile.setCrewInvite(null);

    }
    @Subcommand("invite")
    public void inviteToCrewCommand(final Player sender, Player target){
        Profile senderProfile = instance.getPlayerManager().getProfile(sender);
        Crew crew = instance.getCrewManager().getCrew(sender.getPlayer());
        if(target == null){
            sender.sendMessage(Language.NOT_ONLINE);
            return;
        }
        if(crew == null){
            sender.sendMessage(CC.RED+"You are not in a crew");
            return;
        }

        instance.getCrewManager().inviteToCrew(crew,sender,target);

    }
    @Subcommand("leave")
    public void leaveCrewCommand(final Player sender){
        Profile senderProfile = instance.getPlayerManager().getProfile(sender);
        Crew crew = instance.getCrewManager().getCrew(sender.getPlayer());
        if(crew == null){
            sender.sendMessage(CC.RED+"You are not in a crew");
            return;
        }

        instance.getCrewManager().leaveCrew(sender);

    }

    @Subcommand("disband")
    public void disbandCrewCommand(final Player sender){
        Profile senderProfile = instance.getPlayerManager().getProfile(sender);
        Crew crew = instance.getCrewManager().getCrew(sender.getPlayer());
        if(crew == null){
            sender.sendMessage(CC.RED+"You are not in a crew");
            return;
        }
        if(!crew.isOwner(sender)){
            sender.sendMessage(CC.RED+"You cannot disband if you don't own the crew");
            return;
        }
        instance.getCrewManager().disbandCrew(crew);

    }
}
