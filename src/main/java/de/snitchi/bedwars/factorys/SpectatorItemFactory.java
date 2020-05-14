package de.snitchi.bedwars.factorys;

import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.someapi.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SpectatorItemFactory {

  private final ResourceMessage resourceMessage;

  public SpectatorItemFactory(ResourceMessage resourceMessage) {
    this.resourceMessage = resourceMessage;
  }

  /**
   * Creates a playerTeleportCompass.
   *
   * @return returns the the build item
   */
  public ItemStack createPlayerTeleportCompass() {
    return new ItemBuilder(Material.COMPASS)
        .setDisplayName(resourceMessage.getMessage("ingame.item.player_teleport_compass"))
        .build();
  }

  /**
   * Creates a playerTeleportCompass.
   *
   * @return returns the the build item
   */
  public ItemStack createIngameLeaveItem() {
    return new ItemBuilder(Material.MAGMA_CREAM)
        .setDisplayName(resourceMessage.getMessage("ingame.item.leave_item"))
        .build();
  }
}
