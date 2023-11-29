package me.portmapping.heist.scoreboard.board;

import me.portmapping.heist.scoreboard.board.cooldown.BoardCooldown;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public interface BoardAdapter {
    String getTitle(Player player);
    List<String> getScoreboard(Player player, Board board, Set<BoardCooldown> cooldowns);
}
