package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.PlayerPool;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class IngameQuitListener implements Listener {

  private final PlayerPool playerPool;

  public IngameQuitListener(PlayerPool playerPool) {
    this.playerPool = playerPool;
  }

  /**
   * Use the PlayerQuitEvent for the ingame phase.
   *
   * @param event PlayerQuitEvent
   */
  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerQuit(PlayerQuitEvent event) {
    if (GameState.getCurrentGameState() != GameState.INGAME) {
      return;
    }
    Player player = event.getPlayer();
    playerPool.removeIngamePlayer(player);
    playerPool.removeSpectatorPlayer(player);
  }
}
