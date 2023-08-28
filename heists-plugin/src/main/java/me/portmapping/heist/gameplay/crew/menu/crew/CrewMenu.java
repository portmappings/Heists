package me.portmapping.heist.gameplay.crew.menu.crew;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewChatButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.CrewMemberButton;
import me.portmapping.heist.gameplay.crew.menu.crew.buttons.EmptyCrewMemberButton;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CrewMenu extends Menu {

    private final Heists instance = Heists.getInstance();
    private final Crew crew;

    @Override
    public String getTitle(Player player){
        return CC.t("&4Crew");
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();


        Player owner = crew.getOwner();

        //Placing member buttons in menu - Start

        buttonMap.put(13,new CrewMemberButton(owner,crew,true)); //This is only for the crew owner

        int start = 13+9-1;
        for (int i = 1 ; i<4; i++){
            if(i < crew.getMembers().size()){
                buttonMap.put(start,new CrewMemberButton(crew.getMembers().get(i),crew,false));
            }else {
                buttonMap.put(start, new EmptyCrewMemberButton());
            }
            start++;
        }
        //Placing member buttons in menu - End


        //Util crew buttons - Start
        buttonMap.put(13+9+9, new CrewChatButton());


        return buttonMap;
    }

    @Override
    public int size(final Map<Integer, Button> buttons){
        return 9*4;
    }

}
