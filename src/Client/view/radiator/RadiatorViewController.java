package Client.view.radiator;

import Client.viewmodel.radiator.RadiatorViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RadiatorViewController
{
  @FXML private Label stateLabel;
  private RadiatorViewModel model;

  /** Bind state label to temperature label and initialize model */
  public void init(RadiatorViewModel radiatorViewModel)
  {
    this.model = radiatorViewModel;
    stateLabel.textProperty().bindBidirectional(model.temperatureLabelProperty());
  }

  /** Button method uses model's stateDown method */
  @FXML private void stateDown(ActionEvent actionEvent)
  {
    model.stateDown();
  }
  /** Button method uses model's stateUp method */
  @FXML private void stateUp(ActionEvent actionEvent)
  {
    model.stateUp();
  }



}
