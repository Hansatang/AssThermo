package Shared.radiator.states;

import Shared.radiator.Radiator;

import java.io.Serializable;

public class Power0State implements RadiatorState, Serializable
{
  private static final int POWER = 0;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Lowest state");
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
