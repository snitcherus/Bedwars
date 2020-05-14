package de.snitchi.bedwars.player;

import org.bukkit.entity.Player;

public class TeamYellowPlayer extends MinigamePlayer {

  /**
   * Dependency injection.
   *
   * @param player player to create a new minigame player
   */
  public TeamYellowPlayer(Player player) {
    super(player);
  }
}
