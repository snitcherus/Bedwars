package de.snitchi.bedwars.countdown;

import de.snitchi.bedwars.GameState;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class IngameCounter extends Counter {

  private static final int INGAME_DURATION = 901;

  private final ResourceMessage resourceMessage;
  private final Counter endCounter;
  private final PlayerPool playerPool;

  private final List<Integer> counterDurations = List.of(600, 300, 240, 180, 120, 60);

  /**
   * Dependency Injection.
   *
   * @param plugin          gets the plugin from the Counter class
   * @param resourceMessage injects the ResourceMessage class
   * @param endCounter      injects the EndCounter class
   * @param playerPool      injects the PlayerPool class
   */
  public IngameCounter(Plugin plugin, ResourceMessage resourceMessage,
                       Counter endCounter, PlayerPool playerPool) {
    super(plugin, INGAME_DURATION);
    this.resourceMessage = resourceMessage;
    this.endCounter = endCounter;
    this.playerPool = playerPool;
  }

  @Override
  protected void onCount(int currentCounter) {
    String counterMessage =
        resourceMessage.getMessage("ingame.counter", currentCounter / 60);
    if (counterDurations.contains(currentCounter)) {
      Bukkit.broadcastMessage(counterMessage);
    }
  }

  @Override
  protected void onFinished() {
    endCounter.start();
    GameState.nextGameState();
    playerPool.ingameToEndPlayers();
    playerPool.spectatorToEndPlayers();
  }

  @Override
  protected void onStopped() {
    System.out.println(".");
  }
}
