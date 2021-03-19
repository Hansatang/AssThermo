package Client.model.mediator.temperature;

import Client.model.mediator.propertyChange.NamedPropertyChangeSubject;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double value);


}
