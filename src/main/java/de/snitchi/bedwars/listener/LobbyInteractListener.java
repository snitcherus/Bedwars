package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.LobbyPlayer;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.util.SlotAssignments;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LobbyInteractListener implements Listener {

  private final PlayerPool playerPool;

  public LobbyInteractListener(PlayerPool playerPool) {
    this.playerPool = playerPool;
  }

  /**
   * Use the PlayerInteractEvent for the lobby items.
   *
   * @param event PlayerInteractEvent
   */
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (GameState.getCurrentGameState() != GameState.LOBBY) {
      return;
    }

    event.setCancelled(true);

    Player player = event.getPlayer();
    LobbyPlayer lobbyPlayer = playerPool.getLobbyPlayer(player);

    switch (player.getInventory().getHeldItemSlot()) {
      case SlotAssignments.TEAM_SELECTOR_SLOT:
        lobbyPlayer.openTeamSelectInventory();
        break;
      case SlotAssignments.LOBBY_LEAVE_ITEM_SLOT:
        player.kickPlayer("");
        break;
      default:
        break;
    }
  }
}
