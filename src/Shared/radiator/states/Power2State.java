package Shared.radiator.states;

import Shared.radiator.Radiator;

import java.io.Serializable;

public class Power2State implements RadiatorState, Serializable
{
  private static final int POWER = 2;

  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power3State(radiator));
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
