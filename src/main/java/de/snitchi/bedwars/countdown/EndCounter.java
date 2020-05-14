package de.snitchi.bedwars.countdown;

import de.snitchi.bedwars.util.ResourceMessage;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class EndCounter extends Counter {

  private static final int END_DURATION = 21;

  private final ResourceMessage resourceMessage;

  private final List<Integer> counterDurations = List.of(20, 10, 5, 3, 2, 1);

  public EndCounter(Plugin plugin, ResourceMessage resourceMessage) {
    super(plugin, END_DURATION);
    this.resourceMessage = resourceMessage;
  }

  @Override
  protected void onCount(int currentCounter) {
    String counterMessage =
        resourceMessage.getMessage("end.counter", currentCounter / 60);
    if (counterDurations.contains(currentCounter)) {
      Bukkit.broadcastMessage(counterMessage);
    }
  }

  @Override
  protected void onFinished() {

  }

  @Override
  protected void onStopped() {

  }
}
