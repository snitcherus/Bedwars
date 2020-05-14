package de.snitchi.bedwars.factorys;

import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.bedwars.util.SlotAssignments;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LobbyInventoryFactory {

  private static final int TEAM_CHANGE_INVENTORY_SIZE = 9;
  private final ResourceMessage resourceMessage;
  private final LobbyItemFactory lobbyItemFactory;

  public LobbyInventoryFactory(ResourceMessage resourceMessage) {
    this.resourceMessage = resourceMessage;
    lobbyItemFactory = new LobbyItemFactory(resourceMessage);
  }

  /**
   * Creates the teamChange inventory.
   *
   * @return the inventory
   */
  public Inventory createTeamChange() {
    Inventory inventory = Bukkit.createInventory(null, TEAM_CHANGE_INVENTORY_SIZE, "Test");
    ItemStack teamRed = lobbyItemFactory.createTeamRed();
    ItemStack teamBlue = lobbyItemFactory.createTeamBlue();
    ItemStack teamYellow = lobbyItemFactory.createTeamYellow();
    ItemStack teamGreen = lobbyItemFactory.createTeamGreen();
    inventory.setItem(SlotAssignments.RED_TEAM_SLOT, teamRed);
    inventory.setItem(SlotAssignments.BLUE_TEAM_SLOT, teamBlue);
    inventory.setItem(SlotAssignments.YELLOW_TEAM_SLOT, teamYellow);
    inventory.setItem(SlotAssignments.GREEN_TEAM_SLOT, teamGreen);
    return inventory;
  }
}
