package de.snitchi.bedwars;

import de.snitchi.bedwars.commands.GameStateCmd;
import de.snitchi.bedwars.countdown.Counter;
import de.snitchi.bedwars.countdown.EndCounter;
import de.snitchi.bedwars.countdown.IngameCounter;
import de.snitchi.bedwars.countdown.LobbyCounter;
import de.snitchi.bedwars.listener.IngameJoinListener;
import de.snitchi.bedwars.listener.IngameQuitListener;
import de.snitchi.bedwars.listener.LobbyInteractListener;
import de.snitchi.bedwars.listener.LobbyInventoryClickListener;
import de.snitchi.bedwars.listener.LobbyItemListener;
import de.snitchi.bedwars.listener.LobbyJoinListener;
import de.snitchi.bedwars.listener.LobbyPlayerListener;
import de.snitchi.bedwars.listener.LobbyQuitListener;
import de.snitchi.bedwars.player.PlayerPool;
import de.snitchi.bedwars.player.TeamPlayerPool;
import de.snitchi.bedwars.util.ResourceMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BedwarsPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    loadConfig();

    ResourceMessage resourceMessage = new ResourceMessage();
    PlayerPool playerPool = new PlayerPool(resourceMessage);
    TeamPlayerPool teamPlayerPool = new TeamPlayerPool();
    Counter endCounter = new EndCounter(this, resourceMessage);
    Counter ingameCounter = new IngameCounter(this, resourceMessage, endCounter, playerPool);
    Counter lobbyCounter = new LobbyCounter(this, resourceMessage, ingameCounter, playerPool);

    registerCommands();
    registerListener(playerPool, teamPlayerPool, resourceMessage, lobbyCounter);
  }

  public void loadConfig() {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }

  private void registerCommands() {
    getCommand("gamestate").setExecutor(new GameStateCmd());
  }

  private void registerListener(PlayerPool playerPool, TeamPlayerPool teamPlayerPool,
                                ResourceMessage resourceMessage,
                                Counter lobbyCounter) {
    PluginManager pluginManager = getServer().getPluginManager();

    Listener lobbyJoinListener = new LobbyJoinListener(playerPool, getConfig(), resourceMessage,
        lobbyCounter);
    pluginManager.registerEvents(lobbyJoinListener, this);
    pluginManager.registerEvents(new LobbyQuitListener(getConfig(), lobbyCounter, playerPool,
        resourceMessage), this);

    Listener ingameJoinListener = new IngameJoinListener(playerPool);
    pluginManager.registerEvents(ingameJoinListener, this);

    Listener ingameQuitListener = new IngameQuitListener(playerPool);
    pluginManager.registerEvents(ingameQuitListener, this);

    Listener lobbyInteractListener = new LobbyInteractListener(playerPool);
    pluginManager.registerEvents(lobbyInteractListener, this);

    Listener lobbyInventoryClickListener = new LobbyInventoryClickListener(resourceMessage,
        teamPlayerPool);
    pluginManager.registerEvents(lobbyInventoryClickListener, this);

    Listener lobbyPlayerListener = new LobbyPlayerListener();
    pluginManager.registerEvents(lobbyPlayerListener, this);

    Listener lobbyItemListener = new LobbyItemListener(playerPool);
    pluginManager.registerEvents(lobbyItemListener, this);
  }
}
