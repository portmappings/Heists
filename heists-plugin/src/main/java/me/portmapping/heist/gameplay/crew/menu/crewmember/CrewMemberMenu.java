package me.portmapping.heist.gameplay.crew.menu.crewmember;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.gameplay.crew.builder.Crew;
import me.portmapping.heist.gameplay.crew.menu.crewmember.buttons.KickCrewMemberButton;
import me.portmapping.heist.utils.chat.CC;
import me.portmapping.heist.utils.menu.Button;
import me.portmapping.heist.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CrewMemberMenu extends Menu {

    private final Crew crew;
    private final Player target;

    @Override
    public String getTitle(Player player){
        return CC.DARK_RED+target.getName();
    }
    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        buttonMap.put(13, new KickCrewMemberButton(target,crew));
        return buttonMap;
    }
}
