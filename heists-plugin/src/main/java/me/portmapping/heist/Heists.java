package me.portmapping.heist;

import lombok.Getter;
import me.portmapping.heist.command.CommandHandler;
import me.portmapping.heist.data.player.PlayerManager;
import me.portmapping.heist.gameplay.crew.listener.CrewListener;
import me.portmapping.heist.gameplay.crew.manager.CrewManager;
import me.portmapping.heist.gameplay.guns.listener.GunListener;
import me.portmapping.heist.gameplay.guns.manager.GunManager;
import me.portmapping.heist.gameplay.throwables.listener.ThrowableListener;
import me.portmapping.heist.gameplay.throwables.manager.ThrowableManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Heists extends JavaPlugin {

    @Getter private static Heists instance;
    private boolean disabling = false;
    private me.portmapping.heist.api.Heists api;
    private GunManager gunManager;
    private PlayerManager playerManager;
    private CrewManager crewManager;
    private ThrowableManager throwableManager;
    private CommandHandler commandHandler;
    @Override
    public void onEnable() {

        instance =this;
        this.gunManager = new GunManager(this);
        this.playerManager = new PlayerManager(this);
        this.throwableManager = new ThrowableManager(
                this);
        this.crewManager = new CrewManager(this);
        getServer().getPluginManager().registerEvents(new GunListener(),this);
        getServer().getPluginManager().registerEvents(new ThrowableListener(),this);
        getServer().getPluginManager().registerEvents(new CrewListener(),this);


        this.commandHandler = new CommandHandler(this);
        // Plugin startup logic

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
