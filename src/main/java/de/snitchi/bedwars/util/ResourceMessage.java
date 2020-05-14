package de.snitchi.bedwars.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.bukkit.entity.Player;

public class ResourceMessage {

  public void sendMessage(Player player, String key, Object... replaces) {
    player.sendMessage(getMessage(key, replaces));
  }

  /**
   * Gets the message from the Bedwars resourceBundle.
   *
   * @param key      path to the message
   * @param replaces replaces a part of the message
   * @return formats the message
   */
  public String getMessage(String key, Object... replaces) {
    ResourceBundle bedwarsBundle = ResourceBundle.getBundle("Bedwars");
    String pattern = bedwarsBundle.getString(key);
    return MessageFormat.format(pattern, replaces);
  }
}
