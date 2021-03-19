package Client.network;


import Client.model.mediator.propertyChange.NamedPropertyChangeSubject;
import Shared.radiator.Radiator;

public interface ClientModel extends NamedPropertyChangeSubject
{
  void update();
  Radiator getRadiator();
  void lowerState();
  void higherState();
  void addTemperature(String id, double value);
  void startClient();
}
