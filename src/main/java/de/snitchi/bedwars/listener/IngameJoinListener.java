package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.player.SpectatorPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class IngameJoinListener implements Listener {

  private final PlayerPool playerPool;

  public IngameJoinListener(PlayerPool playerPool) {
    this.playerPool = playerPool;
  }

  /**
   * IngameJoinEvent.
   *
   * @param event playerJoinEvent
   */
  @EventHandler(priority = EventPriority.LOW)
  public void onPlayerJoin(PlayerJoinEvent event) {
    if (GameState.getCurrentGameState() != GameState.INGAME) {
      return;
    }
    Player player = event.getPlayer();
    SpectatorPlayer spectator = playerPool.addSpectatorPlayer(player);
    spectator.initializeSpectator();
    event.setJoinMessage(null);
  }
}
