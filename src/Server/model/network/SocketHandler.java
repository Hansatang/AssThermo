package Server.model.network;

import Server.model.mediator.radiator.RadiatorModel;
import Server.model.mediator.temperature.TemperatureModel;

import Shared.Request;
import Shared.radiator.Radiator;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private RadiatorModel radiatorModel;
  private TemperatureModel temperatureModel;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketHandler(Socket socket, RadiatorModel radiatorModel,
      TemperatureModel temperatureModel)
  {
    this.socket = socket;
    this.radiatorModel = radiatorModel;
    this.temperatureModel = temperatureModel;

    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    try
    {

      Request request = (Request) inFromClient.readObject();
      System.out.println("                " + request.getType());
      if ("Listener".equals(request.getType()))
      {
        System.out.println("3" + request.getArg());
        radiatorModel.addListener("StateChanged", this::onStateChanged);
        temperatureModel
            .addListener("TemperatureChanged", this::onNewTemperature);
        System.out.println(4);
      }
      else if ("Update".equals(request.getType()))
      {
        System.out.println("5" + request.getArg());
        //  radiatorModel.update();
        outToClient
            .writeObject(new Request("Update", radiatorModel.getRadiator()));

      }
      else if ("getRadiator".equals(request.getType()))
      {
        System.out.println("5" + request.getArg());
        Radiator result = radiatorModel.getRadiator();
        outToClient.writeObject(new Request("getRadiator", result));

      }
      else if ("lowerState".equals(request.getType()))
      {
        System.out.println("5" + request.getArg());
        radiatorModel.lowerState();
        outToClient.writeObject(new Request("lowerState", 110));

      }
      else if ("higherState".equals(request.getType()))
      {
        System.out.println("5" + request.getArg());
        radiatorModel.higherState();
        outToClient.writeObject(
            new Request("higherState", radiatorModel.getRadiator()));

      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void onNewTemperature(PropertyChangeEvent evt)
  {
    try
    {
      System.out.println("100" + evt.getPropertyName());
      System.out.println("111" + evt.getOldValue());
      System.out.println("122" + evt.getNewValue());
      outToClient
          .writeObject(new Request(evt.getPropertyName(), evt.getNewValue(),evt.getOldValue()));

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void onStateChanged(PropertyChangeEvent evt)
  {
    try
    {
      System.out.println("10" + evt.getPropertyName());
      System.out.println("11" + evt.getOldValue());
      System.out.println("12" + evt.getNewValue());
      outToClient
          .writeObject(new Request(evt.getPropertyName(), evt.getNewValue()));

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
