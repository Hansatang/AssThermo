package Shared.temperature;


import Shared.utility.DateTime;

import java.io.Serializable;

public class Temperature implements Serializable
{
   private String id;
   private double value;
   private DateTime time;


   /** Constructor initializes id, value and the time.  * */
   public Temperature(String id, double value)
   {
      this.id = id;
      this.value = value;
      time = new DateTime();
   }

   /** Return the temperature.  * */
   public double getValue()
   {
      return value;
   }

   /** Return the thermometer id.  * */
   public String getId() {
      return id;
   }

   /** Format temperature, ID and the current time together in a String object and return it.  * */
   public String toString()
   {
      return String.format("%s: %.1f (%s)", id, value, time.getTimestamp());
   }
}
