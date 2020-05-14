package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.bedwars.util.SlotAssignments;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LobbyInventoryClickListener implements Listener {

  private final ResourceMessage resourceMessage;

  public LobbyInventoryClickListener(ResourceMessage resourceMessage) {
    this.resourceMessage = resourceMessage;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (GameState.getCurrentGameState() == GameState.INGAME) {
      event.setCancelled(false);
      return;
    }

    if(event.getClickedInventory().getType().name() != "Test") {
      return;
    }

    if (event.getSlot() == SlotAssignments.RED_TEAM_SLOT) {

    }

    event.setCancelled(true);
  }
}
