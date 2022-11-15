package worldOfZuul;

import java.util.Set;
import java.util.HashMap;


public class Room 
{
    private String description;
    private String whereToSailNext;
    private HashMap<String, Room> exits;
    private Plastic currentPlastic;
    private DeadFish deadFishDeath;
    public Room(){
        this.description = "Dette rum er tomt";
    }


                        /* Constructors, Accesor and Mutator Methods */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    public Room(String description, String whereToSailNext)
    {
        this.whereToSailNext = whereToSailNext;
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    public Plastic getCurrentPlastic() {
        return currentPlastic;
    }
    public String getWhereToSailNext() {
        return "Den hurtigste vej til havnen er: " + whereToSailNext + ", det tog lang tid at undersøge.";
    }
    public DeadFish getDeadFishDeath() {
        return deadFishDeath;
    }
    public String getShortDescription()
    {
        return description;
    }
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    public String getLongDescription() {
        int plastic = spawnPlastic();
        boolean fish = spawnDeadFish();
//      Hvis man er på havnen
        if (checkRoom()) {
            return "Du er " + description + "\n" + getExitString(); }
//        Hvis der er hverken fisk eller plast
        else if(plastic<100 && !fish){
            return "Du er " + description + ". Der er intet andet end vand" +"\n" + getExitString();}
//        Hvis der er fisk men ikke plast
        else if (plastic<100 && fish) {
            return "Du er " + description + ". Der er en død fisk. For at undersøge skriv >info< "
                    +"\n" + getExitString();}
//        Hvis der er fisk og plast
        else if (plastic>0 && fish) {
            return "Du er " + description + ". Der er en død fisk. For at undersøge skriv >info<"
                    +"\n" +"Der er " +plastic+ " tons plastik i vandet. >indsaml< "+"\n" + getExitString();}
//        Hvis der ikke er fisk men der er plastik
        else if (plastic>0 && !fish) {
            return "Du er " + description + ". Der er " +plastic+ " tons plastik i vandet. >indsaml< "
                    +"\n" + getExitString();}

        return "fejl i indlæsning af område";
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
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }


                                    /* Methods and Functions */
    /** A method that creates an object of the Plastic class */
    public int spawnPlastic(){
        Plastic plastic = new Plastic();
        int amount = 0;
        if(plastic.spawnChance() == true){
            plastic.spawn();
            amount = plastic.getAmount();
        }
        else if (plastic.spawnChance() == false){
            amount = 0;
        }
        this.currentPlastic = plastic;
        return (amount);
    }

    /** A method that creates an object of the DeadFish class */
    public boolean spawnDeadFish(){
        DeadFish fish = new DeadFish();
        boolean deadFish = fish.spawnChance();
        if (deadFish){
            fish.spawn();

        }
        this.deadFishDeath = fish;
        return deadFish;
    }

    /** A method used to check if the player is in the harbor */
    public boolean isHarbor() {
        return false;
    }

    /** A method used to check if the player is in the harbor */
    public boolean checkRoom(){
    if(getShortDescription()=="nu i havnen") {
            return true;
        } else {
            return false;
        }
    }
}

