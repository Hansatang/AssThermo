package Server.model.network;

import Server.model.mediator.radiator.RadiatorModel;
import Server.model.mediator.temperature.TemperatureModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private RadiatorModel radiatorModel;
  private TemperatureModel temperatureModel;

  public SocketServer(RadiatorModel radiatorModel,
      TemperatureModel temperatureModel)
  {
    this.radiatorModel = radiatorModel;
    this.temperatureModel = temperatureModel;
  }

  public void startServer() {
    try {
      ServerSocket welcomeSocket = new ServerSocket(2910);

      while(true) {
        Socket socket = welcomeSocket.accept();
        new Thread(new SocketHandler(socket, radiatorModel,temperatureModel)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
