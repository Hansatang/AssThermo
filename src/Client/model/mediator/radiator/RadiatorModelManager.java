package Client.model.mediator.radiator;



import Shared.radiator.Radiator;
import Client.network.ClientModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
private ClientModel client;

  private PropertyChangeSupport property;

  /** Constructor initializes radiator and Property Change Support.
   * */
  public RadiatorModelManager(ClientModel cf)
  {

    property = new PropertyChangeSupport(this);
    this.client=cf;
    client.addListener("Log", this::onUpdated);
    client.addListener("higherState", this::onHigherState);
    client.addListener("StateChanged", this::onUpdated);
  }

  private void onHigherState(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println(888);
    property.firePropertyChange(propertyChangeEvent);
  }

  private void onUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    property.firePropertyChange(propertyChangeEvent);
  }

  /** Adds a listener to the Property Change Support if the it has a name.
   * */
  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      System.out.println("Add listener error");
    }
    else
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

  /** Updates the state of the radiator.
   * */
  @Override public void update()
  {
   client.update();
  }

  /** Returns the radiator  * */
  @Override public Radiator getRadiator()
  {
   return client.getRadiator();
  }

  /** Tells the radiator to turn one state down.  * */
  @Override public void lowerState()
  {
    client.lowerState();
  }

  /** Tells the radiator to turn one state up.  * */
  @Override public void higherState()
  {
   client.higherState();
  }
}
