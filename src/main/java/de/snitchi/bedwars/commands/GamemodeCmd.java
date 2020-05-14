package de.snitchi.bedwars.commands;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCmd implements CommandExecutor {

  private final List<Integer> gamemodes = List.of(0,1,2,3);
  private final List<String> gamemodeName = List.of("survival", "creative", "adventure",
      "spectator");

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      return true;
    }

    Player player = (Player) sender;
    Player target = Bukkit.getPlayer(args[1]);


    return true;
  }
}
