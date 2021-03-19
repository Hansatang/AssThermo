package Server;

import Server.model.ModelFactory;
import Server.model.mediator.radiator.RadiatorModelManager;
import Server.model.mediator.temperature.TemperatureModelManager;
import Server.model.network.SocketServer;
import Server.model.thermometer.Thermometer;

public class RunServer
{
  public static void main(String[] args)
  {
    ModelFactory mf = new ModelFactory();
    SocketServer ss = new SocketServer(mf.getRadiatorModel(),
        mf.getTemperatureModel());

    /**Thermometers */
    Thermometer therm1 = new Thermometer("1", 25, 1, mf.getTemperatureModel(),
        mf.getRadiatorModel());
    Thermometer therm2 = new Thermometer("2", 15, 7, mf.getTemperatureModel(),
        mf.getRadiatorModel());
    Thread t1 = new Thread(therm1);
    Thread t2 = new Thread(therm2);
    t1.setDaemon(true);
    t1.start();
    t2.setDaemon(true);
    t2.start();

    ss.startServer();
  }
}
