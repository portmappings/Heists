package me.portmapping.heist.gameplay.heists.task;

import lombok.RequiredArgsConstructor;
import me.portmapping.heist.Heists;
import me.portmapping.heist.gameplay.heists.builder.Heist;
import me.portmapping.heist.gameplay.heists.builder.HeistState;
import me.portmapping.heist.gameplay.heists.events.HeistStartEvent;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor

public class HeistTask extends BukkitRunnable {

    private final Heist heist;
    private final Heists instance;
    @Override
    public void run() {
        switch (heist.getState()){
            case WAITING:
                if(heist.getPlayerList().size()>=2){
                    heist.setState(HeistState.STARTING);
                }else{
                    heist.setTimeToStart(12);
                }
                break;
            case STARTING:
                if(heist.getPlayerList().size()>=4){
                    if(heist.getTimeToStart()!=0){
                        heist.setTimeToStart(heist.getTimeToStart()-1);
                        heist.sendMessage(CC.t("&eStarting in: "+heist.getTimeToStart()));
                    }else{
                        heist.setState(HeistState.ACTIVE);
                        instance.getServer().getPluginManager().callEvent(new HeistStartEvent(heist));
                    }
                }
                break;
            case ACTIVE:
                heist.setTimeElapsed(heist.getTimeElapsed()+1);
                break;

        }
    }
}
