package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.TeamPlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.bedwars.util.SlotAssignments;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LobbyInventoryClickListener implements Listener {

  private final ResourceMessage resourceMessage;
  private final TeamPlayerPool teamPlayerPool;

  public LobbyInventoryClickListener(ResourceMessage resourceMessage,
                                     TeamPlayerPool teamPlayerPool) {
    this.resourceMessage = resourceMessage;
    this.teamPlayerPool = teamPlayerPool;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (GameState.getCurrentGameState() == GameState.INGAME) {
      event.setCancelled(false);
      return;
    }

    if (!event.getView().getTitle().equals("Test")) {
      return;
    }

    Player player = (Player) event.getWhoClicked();

    switch (event.getSlot()) {
      case SlotAssignments.RED_TEAM_SLOT:
        teamPlayerPool.addTeamRedPlayer(player);
        return;
      case SlotAssignments.BLUE_TEAM_SLOT:
        teamPlayerPool.addTeamBluePlayer(player);
        return;
      case SlotAssignments.GREEN_TEAM_SLOT:
        teamPlayerPool.addTeamGreenPlayer(player);
        return;
      case SlotAssignments.YELLOW_TEAM_SLOT:
        teamPlayerPool.addTeamYellowPlayer(player);
        return;
      default:
        teamPlayerPool.resetPlayerTeam(player);
        break;
    }

    event.setCancelled(true);
  }
}
