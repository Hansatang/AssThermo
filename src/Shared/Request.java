package Shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private String type;
  private Object arg1;
  private Object arg2;

  public Request(String type, Object arg1)
  {
    this.type = type;
    this.arg1 = arg1;
    this.arg2 = null;
  }

  public Request(String type, Object arg1, Object arg2)
  {
    this.type = type;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  public String getType()
  {
    return type;
  }

  public Object getArg()
  {
    return arg1;
  }

  public Object getArg2()
  {
    return arg2;
  }
}