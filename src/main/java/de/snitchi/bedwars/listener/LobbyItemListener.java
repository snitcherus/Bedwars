package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.PlayerPool;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class LobbyItemListener implements Listener {

  private final PlayerPool playerPool;

  public LobbyItemListener(PlayerPool playerPool) {
    this.playerPool = playerPool;
  }

  /**
   * Use the PlayerDropItemEvent for the lobby phase.
   *
   * @param event PlayerDropItemEvent
   */
  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerDropItem(PlayerDropItemEvent event) {
    Player player = event.getPlayer();
    if (GameState.getCurrentGameState() == GameState.LOBBY) {
      event.setCancelled(true);
      return;
    }

    if (player.getGameMode() == GameMode.SPECTATOR) {
      event.setCancelled(true);
      return;
    }

    event.setCancelled(false);
  }

  /**
   * Use the InventoryClickEvent for the lobby phase.
   *
   * @param event InventoryClickEvent
   */
  @EventHandler(priority = EventPriority.LOWEST)
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    if (GameState.getCurrentGameState() == GameState.LOBBY) {
      event.setCancelled(true);
      return;
    }

    if (player.getGameMode() == GameMode.SPECTATOR) {
      event.setCancelled(true);
      return;
    }

    event.setCancelled(false);
  }
}
