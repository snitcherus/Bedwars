package de.snitchi.bedwars.player;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public abstract class MinigamePlayer {

  private final Player player;

  /**
   * Dependency injection.
   *
   * @param player player to create a new zombieTown player
   */

  public MinigamePlayer(Player player) {
    this.player = player;
  }

  /**
   * Resets the player inventory and potionEffects.
   */
  public void reset() {
    player.getInventory().clear();
    for (PotionEffect potionEffect : player.getActivePotionEffects()) {
      player.removePotionEffect(potionEffect.getType());
    }

    player.setFoodLevel(20);
    player.setHealth(20);
    player.setExp(0.0F);
    player.setLevel(0);
  }

  public Player getPlayer() {
    return player;
  }
}
