package me.portmapping.heist.data.config.manager;

import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.file.Config;
import me.portmapping.heist.utils.file.FileConfig;
import me.portmapping.heist.utils.framework.Manager;

public class ConfigManager extends Manager {
    public FileConfig ammunitionConfig;
    public ConfigManager(Heists instance){
        super(instance);
        this.ammunitionConfig = new FileConfig(getInstance(),"stores/ammunition.yml");
    }

}
