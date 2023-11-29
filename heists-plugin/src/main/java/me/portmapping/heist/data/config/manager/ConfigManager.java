package me.portmapping.heist.data.config.manager;

import lombok.Getter;
import me.portmapping.heist.Heists;
import me.portmapping.heist.utils.file.Config;
import me.portmapping.heist.utils.file.FileConfig;
import me.portmapping.heist.utils.framework.Manager;

import java.io.File;

@Getter
public class ConfigManager extends Manager {
    public FileConfig ammunitionConfig;
    private FileConfig heistsConfig;
    public ConfigManager(Heists instance){
        super(instance);
        this.ammunitionConfig = new FileConfig(getInstance(),"stores/ammunition.yml");
        this.heistsConfig = new FileConfig(getInstance(),"heists.yml");
    }

}
