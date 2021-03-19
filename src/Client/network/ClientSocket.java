package Client.network;

import Shared.radiator.Radiator;
import Shared.temperature.Temperature;
import Shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements ClientModel
{
  private PropertyChangeSupport support;


  public ClientSocket()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(
          socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(
          socket.getInputStream());

      new Thread(() -> listenToServer(outToServer, inFromServer)).start();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer,
      ObjectInputStream inFromServer)
  {
    try
    {
      outToServer.writeObject(new Request("Listener", null));
      while (true)
      {
        Request request = (Request) inFromServer.readObject();
        System.out.println("000"+request.getType());
        System.out.println("111"+request.getArg());
        support.firePropertyChange(request.getType(), request.getArg2(), request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update()
  {
    try
    {
      Request response = request(null, "Update");
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Radiator getRadiator()
  {
    try
    {
      Request response = request(null, "getRadiator");
      return (Radiator) response.getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void lowerState()
  {
    try
    {
      Request response = request(null, "lowerState");
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void higherState()
  {
    try
    {
      Request response = request(null, "higherState");
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addTemperature(String id, double value)
  {
    try
    {
      Request response = request(new Temperature(id, value), "addTemperature");
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }



  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(propertyName, listener);
  }

  private Request request(Object arg, String type)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(
        socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(
        socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    System.out.println("111111");
    Request request = (Request) inFromServer.readObject();
    System.out.println("8"+request.getType());
    System.out.println("9"+request.getArg());
    return request;
  }
}
