package de.snitchi.bedwars;

public enum GameState {

  LOBBY,
  INGAME,
  END;

  private static GameState currentState = LOBBY;

  /**
   * Make the current GameState to the next GameState (Lobby, Ingame, End).
   */
  public static void nextGameState() {
    if (currentState == END) {
      return;
    }

    currentState = GameState.values()[currentState.ordinal() + 1];
  }

  public static GameState getCurrentGameState() {
    return currentState;
  }
}
