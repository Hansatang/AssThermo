package Client.model.mediator.radiator;

import Client.model.mediator.propertyChange.NamedPropertyChangeSubject;
import Shared.radiator.Radiator;

public interface RadiatorModel extends NamedPropertyChangeSubject
{
  void update();
  Radiator getRadiator();
  void lowerState();
  void higherState();
}