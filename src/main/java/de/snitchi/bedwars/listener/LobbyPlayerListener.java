package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class LobbyPlayerListener implements Listener {

  /**
   * Use the EntityDamageEvent for the Lobby phase.
   *
   * @param event EntityDamageEvent
   */
  @EventHandler(priority = EventPriority.LOWEST)
  public void onEntityDamage(EntityDamageEvent event) {
    if (!(event.getEntity() instanceof Player)) {
      return;
    }

    Player player = (Player) event.getEntity();
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

  @EventHandler(priority = EventPriority.LOWEST)
  public void onFoodLevelChange(FoodLevelChangeEvent event) {
    Player player = (Player) event.getEntity();
    stateCheck(event, player);
  }

  private void stateCheck(FoodLevelChangeEvent event, Player player) {
    if (!(event.getEntity() instanceof Player)) {
      return;
    }

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
