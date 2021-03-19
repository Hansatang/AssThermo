package Server.model;

import Server.model.mediator.radiator.RadiatorModel;
import Server.model.mediator.radiator.RadiatorModelManager;
import Server.model.mediator.temperature.TemperatureModel;
import Server.model.mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  /** Returns temperature model, and if it isn't initialized then it does that and returns it.  * */
  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
      temperatureModel = new TemperatureModelManager();
    return temperatureModel;
  }

  /** Returns radiator model, and if it isn't initialized then it does that and returns it.  * */
  public RadiatorModel getRadiatorModel(){
    if (radiatorModel == null){
      radiatorModel = new RadiatorModelManager();
    }
    return radiatorModel;
  }
}
