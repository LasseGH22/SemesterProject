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

    public boolean spawnDeadFish(){
        DeadFish fish = new DeadFish();
        boolean spawn = fish.spawnChance();
        return spawn;
    }

    public String getDeathReason(){
        DeadFish fish = new DeadFish();
        String death = "";
        if(fish.spawnChance()){
            fish.spawn();
            death = fish.getDeathReason();
        } else if (!fish.spawnChance()) {
            death = "";
        }
        return death;
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription() {
        double plastic = spawnPlastic();
        boolean fish = spawnDeadFish();

//        Hvis der er hverken fisk eller plast
        if(plastic<100 && !fish){
            return "Du er " + description + ". Der er intet andet end vand" +"\n" + getExitString();}
//        Hvis der er fisk men ikke plast
        else if (plastic<100 && fish) {
            return "Du er " + description + ". Der er en død fisk "+"\n" + getExitString();}
//        Hvis der er fisk og plast
        else if (plastic>0 && fish) {
            return "Du er " + description + ". Der er en død fisk og "+plastic+"tons plastik i vandet"+"\n" + getExitString();}
//        Hvis der ikke er fisk men der er plastik
        else if (plastic>0 && !fish) {
            return "Du er " + description + ". Der er " +plastic+ "tons plastik i vandet"+"\n" + getExitString();}

        return "fejl i indlæsning af område";
    }
    public String interact(){

        return "";
    }
    public String inHarbor(){
        return "Du er " + description +"\n" + getExitString();}

    public boolean isHarbor() {
        return false;
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

