package Client;




import Client.core.ClientFactory;
import Client.core.ModelFactory;
import Client.view.ViewHandler;
import Client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  @Override public void start(Stage primaryStage)
  {
    /** View */
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler view = new ViewHandler(vmf);
    view.start(primaryStage);

//    /**Thermometers */
//    Thermometer therm1 = new Thermometer("1", 25, 1, mf.getTemperatureModel(),
//        mf.getRadiatorModel());
//    Thermometer therm2 = new Thermometer("2", 15, 7, mf.getTemperatureModel(),
//        mf.getRadiatorModel());
//    Thread t1 = new Thread(therm1);
//    Thread t2 = new Thread(therm2);
//    t1.setDaemon(true);
//    t1.start();
//    t2.setDaemon(true);
//    t2.start();
  }
}
