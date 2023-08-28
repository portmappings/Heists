package me.portmapping.heist.gameplay.crew.listener;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crew.CrewMenu;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.chat.Language;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CrewListener implements Listener {
    private final Heists instance = Heists.getInstance();

    @EventHandler
    public void onCrewChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        Profile profile = instance.getPlayerManager().getProfile(player);
        Crew crew = instance.getCrewManager().getCrew(player);
        if(crew==null){
            return;
        }
        if(player.hasMetadata("crew-invite")){
            return;
        }
        if(profile.isCrewChat()){
            event.setCancelled(true);
            crew.getMembers().forEach(member -> member.sendMessage(CC.BLUE+"[Crew] "+player.getName()+": "+event.getMessage()));
        }
    }

    @EventHandler
    public void inputMemberToInvite(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        Crew crew = instance.getCrewManager().getCrew(player);

        if(!event.getPlayer().hasMetadata("crew-invite")){
            return;
        }
        if(crew == null){
            return;
        }

        //Cancel the event so the message does not get sent to server
        event.setCancelled(true);
        Player target = Bukkit.getPlayer(event.getMessage());

        if(target == null) {
            player.sendMessage(Language.NOT_ONLINE);
            return;
        }


        instance.getCrewManager().inviteToCrew(crew, player, target);
        Menu crewMenu = new CrewMenu(crew);
        crewMenu.openMenu(player);
        player.removeMetadata("crew-invite",instance);



    }

    @EventHandler
    public void crewMemberLeave(PlayerQuitEvent event){

        Player player = event.getPlayer();
        Profile profile = instance.getPlayerManager().getProfile(player);
        Crew crew = instance.getCrewManager().getCrew(player);
        if(crew==null){
            return;
        }
        for(Player members : crew.getMembers()){
            members.sendMessage(CC.RED+player.getName()+" has disconnected");
        }
        instance.getCrewManager().leaveCrew(player);
    }
}
