package me.portmapping.heist.utils.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.portmapping.heist.Heists;

@AllArgsConstructor

public class Manager {
    @Getter
    private Heists instance;
}
