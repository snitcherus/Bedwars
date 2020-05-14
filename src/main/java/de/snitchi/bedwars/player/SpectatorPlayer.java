package de.snitchi.bedwars.player;

import de.snitchi.bedwars.factorys.SpectatorItemFactory;
import de.snitchi.bedwars.util.ResourceMessage;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpectatorPlayer extends MinigamePlayer {

  private static final int PLAYER_TELEPORT_COMPASS_SLOT = 0;
  private static final int INGAME_LEAVE_ITEM_SLOT = 8;

  private final ResourceMessage resourceMessage;
  private final SpectatorItemFactory spectatorItemFactory;

  public SpectatorPlayer(Player player, ResourceMessage resourceMessage) {
    super(player);
    this.resourceMessage = resourceMessage;
    spectatorItemFactory = new SpectatorItemFactory(resourceMessage);
  }

  /**
   * Initialize a spectator.
   */
  public void initializeSpectator() {
    assignSpectatorItems();
    reset();
    getPlayer().setGameMode(GameMode.SPECTATOR);
  }

  private void assignSpectatorItems() {
    ItemStack teleportCompass = spectatorItemFactory.createPlayerTeleportCompass();
    getPlayer().getInventory().setItem(PLAYER_TELEPORT_COMPASS_SLOT, teleportCompass);
    ItemStack leaveItem = spectatorItemFactory.createIngameLeaveItem();
    getPlayer().getInventory().setItem(INGAME_LEAVE_ITEM_SLOT, leaveItem);
  }
}
