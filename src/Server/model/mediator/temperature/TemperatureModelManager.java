package Server.model.mediator.temperature;

import Shared.temperature.Temperature;
import Shared.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport property;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    property = new PropertyChangeSupport(this);
  }

  /** Adds a temperature to the temperature list.  * */
  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    temperatureList.addTemperature(temperature);
    if (id.equals("1"))
    {
      System.out.println("Temp2 " + temperatureList.getLastTemperature("2"));
      System.out.println("Temp1 " + temperatureList.getLastTemperature("1"));
      property.firePropertyChange("TemperatureChanged", temperatureList.getLastTemperature("2"),
          temperatureList.getLastTemperature("1"));
    }
  }

  @Override public void addTemperature(String id, Temperature temperature)
  {
    temperatureList.addTemperature(temperature);
    if (temperatureList.getLastTemperature("2") != null)
    {
      if (temperatureList.getLastTemperature("1") != null)
      {
        property.firePropertyChange("TemperatureChanged",
            temperatureList.getLastTemperature("2"),
            temperatureList.getLastTemperature("1"));
      }
    }
  }

  /** Add listener to the Property Change Support object initialized in the constructor.  * */
  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) /** all events  * */
    {
      property.addPropertyChangeListener(listener);
    }
    else /** a specific event  * */
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

}
