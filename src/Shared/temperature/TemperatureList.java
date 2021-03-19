package Shared.temperature;

import java.util.ArrayList;

public class TemperatureList
{
   private ArrayList<Temperature> list;

   /** Constructor initializes the ArrayList object list.  * */
   public TemperatureList()
   {
      this.list = new ArrayList<>();
   }

   /** Add a temperature to the ArrayList object list.  * */
   public void addTemperature(Temperature temperature)
   {
      list.add(temperature);
   }

   /** Return the latest temperature added with the inputted ID.  * */
   public Temperature getLastTemperature(String id)
   {
      if (list.size() < 1)
      {
         return null;
      }
      if (id == null)
      {
         return list.get(list.size()-1);
      }
      for (int i=list.size()-1; i>=0; i--)
      {
         if (id.equals(list.get(i).getId()))
         {
            return list.get(i);
         }
      }
      return null;
   }

   /** Returns size of list, if there should be a for-loop to run through it.  * */
   public int getSize()
   {
      return list.size();
   }

   /** Return the list into a String.  * */
   public String toString()
   {
      String s = "{";
      for (int i = 0; i < list.size(); i++)
      {
         s += list.get(i);
         if (i < list.size() - 1)
         {
            s += ", ";
         }
      }
      return s;
   }
}
