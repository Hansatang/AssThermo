package Client.view.temperature;

import Client.viewmodel.temperature.TemperatureViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperatureViewController
{
  /** Initialize JavaFX nodes */
  @FXML private Label Warn1;
  @FXML private Label Warn2;
  @FXML private TextField MaxTemp;
  @FXML private TextField MinTemp;
  @FXML private Label outputLabel1;
  @FXML private Label outputLabel;

  private TemperatureViewModel model;

  public void init(TemperatureViewModel temperatureViewModel)
  {
    this.model = temperatureViewModel;
    outputLabel.textProperty().bindBidirectional(model.outputLabelProperty());
    outputLabel1.textProperty().bindBidirectional(model.outputLabel1Property());
    MaxTemp.textProperty().bindBidirectional(model.maxTempProperty());
    MinTemp.textProperty().bindBidirectional(model.minTempProperty());
    Warn1.textProperty().bindBidirectional(model.warn1Property());
    Warn2.textProperty().bindBidirectional(model.warn2Property());
  }

  /** Button to change to current inputted max/minimum values. */
  @FXML private void onChoose(ActionEvent actionEvent)
  {
    model.onChoose();
  }

}
