package de.snitchi.bedwars.player;

import de.snitchi.bedwars.util.ResourceMessage;
import org.bukkit.entity.Player;

public class IngamePlayer extends MinigamePlayer {

  public IngamePlayer(Player player, ResourceMessage resourceMessage) {
    super(player);
  }

  public void initializeIngame() {
    reset();
  }
}
