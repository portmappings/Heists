package me.portmapping.heist.provider;

import me.portmapping.heist.Heists;
import me.portmapping.heist.data.player.Profile;
import me.portmapping.heist.scoreboard.board.Board;
import me.portmapping.heist.scoreboard.board.BoardAdapter;
import me.portmapping.heist.scoreboard.board.cooldown.BoardCooldown;
import me.portmapping.heist.utils.chat.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ScoreboardProvider implements BoardAdapter, Listener {

    private final Heists instance;
    public ScoreboardProvider(Heists instance) {
        this.instance = instance;
        Bukkit.getPluginManager().registerEvents(this,instance);
    }
    @Override
    public String getTitle(Player player) {
        return CC.t("&b&lHeists");
    }

    @Override
    public List<String> getScoreboard(Player player, Board board, Set<BoardCooldown> cooldowns) {
        Profile profile = instance.getPlayerManager().getProfile(player);
        List<String> strings = new LinkedList<>();
        strings.add(CC.t("&2&lCash: &f$"+profile.getCash()));
        strings.add(CC.t("&4&lBank: &f$"+profile.getBankMoney()));
        return strings;
    }
}
