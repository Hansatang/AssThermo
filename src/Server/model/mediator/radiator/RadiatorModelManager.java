package Server.model.mediator.radiator;

import Shared.Request;
import Shared.radiator.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{
  private Radiator radiator;
  private PropertyChangeSupport property;

  /** Constructor initializes radiator and Property Change Support.
   * */
  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
    property = new PropertyChangeSupport(this);
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
    property
        .firePropertyChange("StateChanged", null, radiator.getCurrentState());
  }

  /** Returns the radiator  * */
  @Override public Radiator getRadiator()
  {
    return radiator;
  }

  /** Tells the radiator to turn one state down.  * */
  @Override public void lowerState()
  {
    System.out.println(radiator.getCurrentState());
    radiator.downTurn();
    Request request = new Request("lowerState", radiator.getCurrentState());
    System.out.println("9"+radiator.getCurrentState());
    property
        .firePropertyChange("StateChanged", null, request);
  }

  /** Tells the radiator to turn one state up.  * */
  @Override public void higherState()
  {
    System.out.println("8"+radiator.getCurrentState());
    radiator.upTurn();
    Request request = new Request("higherState", radiator.getCurrentState());
    System.out.println("9"+radiator.getCurrentState());
    property
        .firePropertyChange("StateChanged", null, request);
  }
}
