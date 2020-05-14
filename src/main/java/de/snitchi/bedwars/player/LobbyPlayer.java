package de.snitchi.bedwars.player;

import de.snitchi.bedwars.factorys.LobbyInventoryFactory;
import de.snitchi.bedwars.factorys.LobbyItemFactory;
import de.snitchi.bedwars.util.ResourceMessage;
import de.snitchi.bedwars.util.SlotAssignments;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LobbyPlayer extends MinigamePlayer {

  private final LobbyItemFactory lobbyItemFactory;
  private final LobbyInventoryFactory lobbyInventoryFactory;

  /**
   * Dependency injection.
   *
   * @param player          gets the player from the MinigamePlayer class
   * @param resourceMessage injects the ResourceMessage class
   */
  public LobbyPlayer(Player player, ResourceMessage resourceMessage) {
    super(player);
    lobbyItemFactory = new LobbyItemFactory(resourceMessage);
    lobbyInventoryFactory = new LobbyInventoryFactory(resourceMessage);
  }

  /**
   * Initialize the lobby.
   */
  public void initializeLobby() {
    reset();
    assignLobbyItems();
    getPlayer().setGameMode(GameMode.ADVENTURE);
  }

  private void assignLobbyItems() {
    ItemStack lobbyTeamSelector = lobbyItemFactory.createLobbyTeamSelector();
    getPlayer().getInventory().setItem(SlotAssignments.TEAM_SELECTOR_SLOT, lobbyTeamSelector);
    ItemStack lobbyLeaveItem = lobbyItemFactory.createLobbyLeaver();
    getPlayer().getInventory().setItem(SlotAssignments.LOBBY_LEAVE_ITEM_SLOT, lobbyLeaveItem);
  }

  public void openTeamSelectInventory() {
    Inventory inventory = lobbyInventoryFactory.createTeamChange();
    getPlayer().openInventory(inventory);
  }
}
