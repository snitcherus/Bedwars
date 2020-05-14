package de.snitchi.bedwars.factorys;

import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.someapi.ItemBuilder;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class LobbyItemFactory {

  private final ResourceMessage resourceMessage;

  public LobbyItemFactory(ResourceMessage resourceMessage) {
    this.resourceMessage = resourceMessage;
  }

  /**
   * Creates the teamSelector item.
   */
  public ItemStack createLobbyTeamSelector() {
    return new ItemBuilder(Material.RED_BED)
        .setDisplayName(resourceMessage.getMessage("lobby.item.team_selector_title"))
        .build();
  }

  /**
   * Creates the lobbyLeaveItem.
   */
  public ItemStack createLobbyLeaver() {
    return new ItemBuilder(Material.MAGMA_CREAM)
        .setDisplayName(resourceMessage.getMessage("lobby.item.leave_item")).build();
  }

  public ItemStack createTeamRed() {
    return ItemBuilder.createWool(DyeColor.RED)
                      .setDisplayName(resourceMessage.getMessage("lobby.item.red_team")).build();
  }

  public ItemStack createTeamBlue() {
    return ItemBuilder.createWool(DyeColor.BLUE)
                      .setDisplayName(resourceMessage.getMessage("lobby.item.blue_team")).build();
  }

  public ItemStack createTeamYellow() {
    return ItemBuilder.createWool(DyeColor.YELLOW)
                      .setDisplayName(resourceMessage.getMessage("lobby.item.yellow_team")).build();
  }

  public ItemStack createTeamGreen() {
    return ItemBuilder.createWool(DyeColor.GREEN)
                      .setDisplayName(resourceMessage.getMessage("lobby.item.green_team")).build();
  }
}
