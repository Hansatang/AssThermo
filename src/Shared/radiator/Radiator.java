package Shared.radiator;

import Shared.radiator.states.Power0State;
import Shared.radiator.states.RadiatorState;

import java.io.Serializable;

public class Radiator implements Serializable
{

  private RadiatorState currentState;

  public Radiator()
  {
    this.currentState = new Power0State();
  }

  public RadiatorState getCurrentState()
  {
    return currentState;
  }

  public void upTurn()
  {
    currentState.turnUp(this);
  }

  public void downTurn()
  {
    currentState.turnDown(this);
  }

  public void setPowerState(RadiatorState state)
  {
    currentState = state;
  }

  public int getPower()
  {
    return currentState.getPower();
  }

}
