package Client.viewmodel;



import Client.core.ModelFactory;
import Client.viewmodel.radiator.RadiatorViewModel;
import Client.viewmodel.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureViewModel;
  private RadiatorViewModel radiatorViewModel;

  /** Initialize values */

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    this.temperatureViewModel = new TemperatureViewModel(
        mf.getTemperatureModel());
    this.radiatorViewModel = new RadiatorViewModel(mf.getRadiatorModel());
  }



  /** Return  object */
  public TemperatureViewModel getTemperatureViewModel()
  {
    if (temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(mf.getTemperatureModel());
    }
    return temperatureViewModel;
  }

  /** Return  object */
  public RadiatorViewModel getRadiatorViewModel()
  {
    if (radiatorViewModel == null)
    {
      radiatorViewModel = new RadiatorViewModel(mf.getRadiatorModel());
    }
    return radiatorViewModel;
  }
}
