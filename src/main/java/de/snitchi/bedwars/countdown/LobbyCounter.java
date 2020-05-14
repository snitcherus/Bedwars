package de.snitchi.bedwars.countdown;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class LobbyCounter extends Counter {

  private static final int LOBBY_DURATION = 61;

  private final ResourceMessage resourceMessage;
  private final Counter ingameCounter;
  private final PlayerPool playerPool;

  private final List<Integer> counterDurations = List.of(60, 30, 10, 5, 4, 3, 2, 1);

  /**
   * Dependency Injection.
   *
   * @param plugin          gets the plugin from the Counter class
   * @param resourceMessage inject the ResourceMessage class
   * @param ingameCounter   inject the IngameCounter class
   * @param playerPool      injects the PlayerPool class
   */
  public LobbyCounter(Plugin plugin, ResourceMessage resourceMessage,
                      Counter ingameCounter, PlayerPool playerPool) {
    super(plugin, LOBBY_DURATION);
    this.resourceMessage = resourceMessage;
    this.ingameCounter = ingameCounter;
    this.playerPool = playerPool;
  }

  @Override
  protected void onCount(int currentCounter) {
    String counterMessage = resourceMessage.getMessage("lobby.counter", currentCounter);
    if (counterDurations.contains(currentCounter)) {
      Bukkit.broadcastMessage(counterMessage);
    }
  }

  @Override
  protected void onFinished() {
    GameState.nextGameState();
    playerPool.lobbyToIngamePlayers();

    for (Player p : Bukkit.getOnlinePlayers()) {
      Player player = (Player) playerPool.getLobbyPlayer(p);
      player.teleport(player); //Location einfügen
    }
    ingameCounter.start();
  }

  @Override
  protected void onStopped() {
    Bukkit.broadcastMessage("Stopped");
  }
}
