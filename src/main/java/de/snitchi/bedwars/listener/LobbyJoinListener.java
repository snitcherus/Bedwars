package de.snitchi.bedwars.listener;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.countdown.Counter;
import de.snitchi.bedwars.player.LobbyPlayer;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LobbyJoinListener implements Listener {

  private final PlayerPool playerPool;
  private final Configuration config;
  private final ResourceMessage resourceMessage;
  private final Counter lobbyCounter;

  /**
   * Dependency injection.
   *
   * @param playerPool      injects the PlayerPool class
   * @param config          injects the Config class
   * @param resourceMessage injects the ResourceMessage class
   * @param lobbyCounter    injects the LobbyCounter class
   */
  public LobbyJoinListener(PlayerPool playerPool,
                           Configuration config,
                           ResourceMessage resourceMessage,
                           Counter lobbyCounter) {
    this.playerPool = playerPool;
    this.config = config;
    this.resourceMessage = resourceMessage;
    this.lobbyCounter = lobbyCounter;
  }

  /**
   * This is a playerJoinEvent method.
   *
   * @param event playerJoinEvent
   */
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    if (GameState.getCurrentGameState() != GameState.LOBBY) {
      return;
    }
    if (Bukkit.getOnlinePlayers().size() >= config.getInt("min_required_player_count")) {
      lobbyCounter.start();
    }

    Player player = event.getPlayer();
    LobbyPlayer lobbyPlayer = playerPool.addLobbyPlayer(player);
    lobbyPlayer.initializeLobby();
    String joinMessage = resourceMessage.getMessage("lobby.join_message", player.getDisplayName());
    event.setJoinMessage(joinMessage);
  }
}
