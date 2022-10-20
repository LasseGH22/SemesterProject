package worldOfZuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public double spawnPlastic(){
        Plastic plastic = new Plastic();
        double amount = 0.0;
        if(plastic.spawnChance() == true){
            plastic.spawn();
            amount = plastic.getAmount();
        }
        else if (plastic.spawnChance() == false){
            amount = 0.0;
        }
        return ((int)amount);
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "Du er " + description + ". Der er "+ spawnPlastic() + " antal tons plast." + "\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Udveje:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

