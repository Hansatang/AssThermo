package Shared.radiator.states;

import Shared.radiator.Radiator;

import java.io.Serializable;

public class Power1State implements RadiatorState, Serializable
{
  private static final int POWER = 1;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power0State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
