package de.snitchi.bedwars.player;

import com.google.common.collect.Maps;
import de.snitchi.bedwars.util.ResourceMessage;
import java.util.Map;
import org.bukkit.entity.Player;

public class PlayerPool {

  private final ResourceMessage resourceMessage;

  private final Map<Player, LobbyPlayer> lobbyPlayers = Maps.newHashMap();
  private final Map<Player, IngamePlayer> ingamePlayers = Maps.newHashMap();
  private final Map<Player, SpectatorPlayer> spectators = Maps.newHashMap();
  private final Map<Player, EndPlayer> endPlayers = Maps.newHashMap();

  public PlayerPool(ResourceMessage resourceMessage) {
    this.resourceMessage = resourceMessage;
  }

  /**
   * Adds the joined lobby player to the pool.
   *
   * @param player the player to add
   * @return the lobby player
   */
  public LobbyPlayer addLobbyPlayer(Player player) {
    LobbyPlayer lobbyPlayer = new LobbyPlayer(player, resourceMessage);
    lobbyPlayers.put(player, lobbyPlayer);
    return lobbyPlayer;
  }

  public LobbyPlayer removeLobbyPlayer(Player player) {
    return lobbyPlayers.remove(player);
  }

  public IngamePlayer removeIngamePlayer(Player player) {
    return ingamePlayers.remove(player);
  }

  public SpectatorPlayer removeSpectatorPlayer(Player player) {
    return spectators.remove(player);
  }

  public LobbyPlayer getLobbyPlayer(Player player) {
    return lobbyPlayers.get(player);
  }

  public SpectatorPlayer getSpectatorPlayer(Player player) {
    return spectators.get(player);
  }

  public IngamePlayer getIngamePlayer(Player player) {
    return ingamePlayers.get(player);
  }

  public void lobbyToIngamePlayers() {
    lobbyPlayers.values()
                .forEach(p -> ingamePlayers.put(p.getPlayer(), mapLobbyToIngamePlayer(p)));
  }

  private IngamePlayer mapLobbyToIngamePlayer(LobbyPlayer lobbyPlayer) {
    return new IngamePlayer(lobbyPlayer.getPlayer(), resourceMessage);
  }

  public void ingameToEndPlayers() {
    ingamePlayers.values()
                 .forEach(p -> endPlayers.put(p.getPlayer(), mapIngameToEndPlayer(p)));
  }

  private EndPlayer mapIngameToEndPlayer(IngamePlayer ingamePlayer) {
    return new EndPlayer(ingamePlayer.getPlayer(), resourceMessage);
  }

  public void spectatorToEndPlayers() {
    spectators.values()
              .forEach(p -> endPlayers.put(p.getPlayer(), mapSpectatorToEndPlayer(p)));
  }

  private EndPlayer mapSpectatorToEndPlayer(SpectatorPlayer spectatorPlayer) {
    return new EndPlayer(spectatorPlayer.getPlayer(), resourceMessage);
  }

  /**
   * Adds the player to the spectators list.
   *
   * @param player Bukkit Player
   * @return the spectatorPlayer
   */
  public SpectatorPlayer addSpectatorPlayer(Player player) {
    SpectatorPlayer spectatorPlayer = new SpectatorPlayer(player, resourceMessage);
    spectators.put(player, spectatorPlayer);
    return spectatorPlayer;
  }
}
