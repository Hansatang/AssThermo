package Server.model.mediator.temperature;

import Server.model.mediator.propertyChange.NamedPropertyChangeSubject;
import Shared.temperature.Temperature;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double value);
  void addTemperature(String id, Temperature temperature);


}
