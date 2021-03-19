package Client.core;

import Client.model.mediator.radiator.RadiatorModel;
import Client.model.mediator.radiator.RadiatorModelManager;
import Client.model.mediator.temperature.TemperatureModel;
import Client.model.mediator.temperature.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;
  private final ClientFactory cf;

  public ModelFactory(ClientFactory cf) {
    this.cf = cf;
  }

  /** Returns temperature model, and if it isn't initialized then it does that and returns it.  * */
  public TemperatureModel getTemperatureModel()
  {
    if (temperatureModel == null)
      temperatureModel = new TemperatureModelManager(cf.getClient());
    return temperatureModel;
  }

  /** Returns radiator model, and if it isn't initialized then it does that and returns it.  * */
  public RadiatorModel getRadiatorModel(){
    if (radiatorModel == null){
      radiatorModel = new RadiatorModelManager(cf.getClient());
    }
    return radiatorModel;
  }
}
