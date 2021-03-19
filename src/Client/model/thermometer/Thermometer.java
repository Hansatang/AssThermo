package Client.model.thermometer;

import Client.model.mediator.radiator.RadiatorModel;
import Client.model.mediator.temperature.TemperatureModel;

public class Thermometer implements Runnable
{
  private String id;
  private double t;
  private int d;
  private TemperatureModel temperatureModel;
  private RadiatorModel radiatorModel;

  /** Constructor initializes values with inputted values.  * */
  public Thermometer(String id, double temp, int d,
      TemperatureModel temperatureModel, RadiatorModel radiatorModel)
  {
    this.id = id;
    this.t = temp;
    this.d = d;
    this.temperatureModel = temperatureModel;
    this.radiatorModel = radiatorModel;
  }

  /** Returns a double of a temperature.  * */
  private double temperature(int p, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }

    double outdoorTerm = (t - t0) * s / 250.0;
    this.t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  /** Thread run method.  * */
  @Override public void run()
  {
    while (true)
    {
      temperatureModel.addTemperature(id, temperature(radiatorModel.getRadiator().getCurrentState().getPower(), 0, 6));
      radiatorModel.update();
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
