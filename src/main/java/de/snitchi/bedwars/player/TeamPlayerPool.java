package de.snitchi.bedwars.player;

import com.google.common.collect.Maps;
import java.util.Map;
import org.bukkit.entity.Player;

public class TeamPlayerPool {

  private final Map<Player, TeamRedPlayer> redPlayers = Maps.newHashMap();
  private final Map<Player, TeamBluePlayer> bluePlayers = Maps.newHashMap();
  private final Map<Player, TeamYellowPlayer> yellowPlayers = Maps.newHashMap();
  private final Map<Player, TeamGreenPlayer> greenPlayers = Maps.newHashMap();

  public TeamRedPlayer addTeamRedPlayer(Player player) {
    TeamRedPlayer teamPlayer = new TeamRedPlayer(player);
    redPlayers.put(player, teamPlayer);
    return teamPlayer;
  }

  public TeamBluePlayer addTeamBluePlayer(Player player) {
    TeamBluePlayer teamPlayer = new TeamBluePlayer(player);
    bluePlayers.put(player, teamPlayer);
    return teamPlayer;
  }

  public TeamYellowPlayer addTeamYellowPlayer(Player player) {
    TeamYellowPlayer teamPlayer = new TeamYellowPlayer(player);
    yellowPlayers.put(player, teamPlayer);
    return teamPlayer;
  }

  public TeamGreenPlayer addTeamGreenPlayer(Player player) {
    TeamGreenPlayer teamPlayer = new TeamGreenPlayer(player);
    greenPlayers.put(player, teamPlayer);
    return teamPlayer;
  }

  public void resetPlayerTeam(Player player) {
    redPlayers.remove(player);
    bluePlayers.remove(player);
    yellowPlayers.remove(player);
    greenPlayers.remove(player);
  }
}
