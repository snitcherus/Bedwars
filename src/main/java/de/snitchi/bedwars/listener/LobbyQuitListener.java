package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.countdown.Counter;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LobbyQuitListener implements Listener {

  private final Configuration config;
  private final Counter lobbyCounter;
  private final PlayerPool playerPool;
  private final ResourceMessage resourceMessage;

  /**
   * Dependency injection.
   *
   * @param config          injects the config.
   * @param lobbyCounter    injects the lobbyCounter
   * @param playerPool      injects the playerPool
   * @param resourceMessage injects the resourceMessage
   */
  public LobbyQuitListener(Configuration config,
                           Counter lobbyCounter, PlayerPool playerPool,
                           ResourceMessage resourceMessage) {
    this.config = config;
    this.lobbyCounter = lobbyCounter;
    this.playerPool = playerPool;
    this.resourceMessage = resourceMessage;
  }

  /**
   * Use the PlayerQuitEvent for the lobby phase.
   *
   * @param event PlayerQuitEvent
   */
  @EventHandler(priority = EventPriority.LOWEST)
  public void onPlayerQuit(PlayerQuitEvent event) {
    System.out.println("LobbyQuitListener.onPlayerQuit");
    if (GameState.getCurrentGameState() != GameState.LOBBY) {
      return;
    }

    Player player = event.getPlayer();
    playerPool.removeLobbyPlayer(player);
    String quitMessage = resourceMessage.getMessage("lobby.leave_message", player.getDisplayName());
    event.setQuitMessage(quitMessage);

    if (Bukkit.getOnlinePlayers().size() < config.getInt("min_required_player_count")) {
      System.out.println("Stopped Lobbycounter");
      lobbyCounter.stop();
    }
  }
}
