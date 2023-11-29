package me.portmapping.heist.scoreboard;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class USBOptions {
    static USBOptions defaultOptions() {
        return new USBOptions()
                .hook(true)
                .scoreDirectionDown(false);
    }

    private boolean hook;
    private boolean scoreDirectionDown;
}
