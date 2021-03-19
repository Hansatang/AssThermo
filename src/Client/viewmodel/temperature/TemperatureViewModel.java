package Client.viewmodel.temperature;

import Client.model.mediator.temperature.TemperatureModel;
import Shared.temperature.Temperature;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewModel implements PropertyChangeListener
{
  private StringProperty outputLabel;
  private StringProperty Warn1;
  private StringProperty Warn2;
  private StringProperty outputLabel1;
  private StringProperty MaxTemp;
  private StringProperty MinTemp;
  private double maxT = 30;
  private double minT = 10;

  private TemperatureModel temperatureModel;


  public TemperatureViewModel(TemperatureModel temperatureModel)
  {
    this.temperatureModel = temperatureModel;
    temperatureModel.addListener("TemperatureChanged", this);
    outputLabel = new SimpleStringProperty();
    outputLabel1 = new SimpleStringProperty();
    MaxTemp = new SimpleStringProperty();
    MinTemp = new SimpleStringProperty();
    Warn1 = new SimpleStringProperty();
    Warn2 = new SimpleStringProperty();
  }

  public StringProperty warn1Property()
  {
    return Warn1;
  }

  public StringProperty warn2Property()
  {
    return Warn2;
  }

  public StringProperty maxTempProperty()
  {
    return MaxTemp;
  }

  public StringProperty minTempProperty()
  {
    return MinTemp;
  }

  public StringProperty outputLabelProperty()
  {
    return outputLabel;
  }

  public StringProperty outputLabel1Property()
  {
    return outputLabel1;
  }

  public void onChoose()
  {
    if (MaxTemp.get() != null)
    {
      maxT = Double.parseDouble((MaxTemp.get()));
    }
    if (MinTemp.get() != null)
    {
      minT = Double.parseDouble((MinTemp.get()));
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(new Runnable()
    {
      @Override public void run()
      {
        Temperature temperature = (Temperature) evt.getNewValue();
        if (evt.getNewValue() != null)
        {
          outputLabel.set(evt.getNewValue().toString());
          if (temperature.getValue() > maxT)
          {
            Warn1.set("OverHeating");
          }
          else if (temperature.getValue() < minT)
          {
            Warn1.set("UnderHeating");
          }
          else
          {
            Warn1.set(null);
          }
        }
        Temperature temperature2 = (Temperature) evt.getOldValue();
        if (evt.getOldValue() != null)
        {
          outputLabel1.set(evt.getOldValue().toString());
          if (temperature2.getValue() > maxT)
          {
            Warn2.set("OverHeating");
          }
          else if (temperature2.getValue() < minT)
          {
            Warn2.set("UnderHeating");
          }
          else
          {
            Warn2.set(null);
          }
        }
      }
    });
  }
}
