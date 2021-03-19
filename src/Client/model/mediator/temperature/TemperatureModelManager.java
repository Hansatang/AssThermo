package Client.model.mediator.temperature;

import Client.network.ClientModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{

  private PropertyChangeSupport property;
  private ClientModel client;

  public TemperatureModelManager(ClientModel cf)
  {

    property = new PropertyChangeSupport(this);
    this.client = cf;
    client.addListener("updated", this::onUpdated);
  }

  /** Adds a temperature to the temperature list.  * */
  @Override public void addTemperature(String id, double value)
  {
    client.addTemperature(id,value);
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

  private void onUpdated(PropertyChangeEvent propertyChangeEvent)
  {
   property.firePropertyChange(propertyChangeEvent);
  }
}
