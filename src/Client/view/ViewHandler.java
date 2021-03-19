package Client.view;

import Client.view.radiator.RadiatorViewController;
import Client.view.temperature.TemperatureViewController;
import Client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler extends Application
{
  private Stage stage;

  private ViewModelFactory vmf;

  /** Constructor initializes ViewModelFactory object. */
  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }


  /** Initialize Stage object and runs openView() and openRadiator() upon GUI start. */
  public void start(Stage primaryStage)
  {
    this.stage = primaryStage;
    openView();
    openRadiator();
  }

  /** Set the stage to TemperatureView.fxml, set title and show the window */
  public void openView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(
        getClass().getResource("../view/temperature/TemperatureView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    TemperatureViewController ctrl = loader.getController();
    ctrl.init(vmf.getTemperatureViewModel());
    stage.setTitle("Thermometer");
    stage.setScene(new Scene(root));
    stage.show();
  }

  /** Set the stage to RadiatorView.fxml, set title and show the window */
  public void openRadiator()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(
        getClass().getResource("../view/radiator/RadiatorView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    RadiatorViewController view = loader.getController();
    view.init(vmf.getRadiatorViewModel());
    Stage localStage = new Stage();
    localStage.setTitle("Heater");
    localStage.setScene(new Scene(root));
    localStage.setY(176);
    localStage.setX(1031);
    localStage.show();
  }
}
