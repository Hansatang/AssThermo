package Client.viewmodel.radiator;

import Client.model.mediator.radiator.RadiatorModel;
import Shared.radiator.states.RadiatorState;
import Shared.Request;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RadiatorViewModel implements PropertyChangeListener
{
  private StringProperty temperatureLabel;
  private RadiatorModel radiatorModel;

  /** Constructor initializes RadiatorModel object and StringProperty object temperatureLabel.
   *  RadiatorModel object adds a this (RadiatorViewModel) as a listener. */
  public RadiatorViewModel(RadiatorModel radiatorModel)
  {
    this.radiatorModel = radiatorModel;
    radiatorModel.addListener("StateChanged", this::change);
    //radiatorModel.addListener("StateChanged", this);
    radiatorModel.addListener("higherState", this::onHigherState);
    temperatureLabel = new SimpleStringProperty();
  }

  private void change(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        System.out.println("Karamba");
        Request request = (Request) evt.getNewValue();
        RadiatorState radiatorState = (RadiatorState) request.getArg();
        temperatureLabel.set(radiatorState.getPower()+" State");
      }
    });
  }

  private void onHigherState(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println(999);
        RadiatorState radiatorState  = (RadiatorState) propertyChangeEvent.getNewValue();
        temperatureLabel.set(radiatorState.getPower()+" State");
  }

  /** Return temperatureLabel */
  public StringProperty temperatureLabelProperty()
  {
    return temperatureLabel;
  }



  /** Update the label upon Radiator state change */
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        System.out.println("Karamba");
        RadiatorState radiatorState  = (RadiatorState) evt.getNewValue();
        temperatureLabel.set(radiatorState.getPower()+" State");
      }
    });
  }

  /** Turn down a state */
  public void stateDown()
  {
    radiatorModel.lowerState();
  }

  /** Turn up a state */
  public void stateUp()
  {
    radiatorModel.higherState();
  }
}
