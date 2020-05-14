package de.snitchi.bedwars.player;

import org.bukkit.entity.Player;

public class TeamBluePlayer extends MinigamePlayer {

  /**
   * Dependency injection.
   *
   * @param player player to create a new minigame player
   */
  public TeamBluePlayer(Player player) {
    super(player);
  }
}
