package worldOfZuul;

import java.util.ArrayList;

public class Ship {


    private ArrayList<Spawnable> inventory;
    private int capacityMax;
    private int capacity;

    //Constructor
    public Ship() {
        //Creates a list
        this.inventory = new ArrayList<Spawnable>();
        //Sets the maximum capacity of the ship.
        this.capacityMax = 12000;
        //Sets the current capacity of the ship.
        this.capacity = 0;

    }
    public ArrayList<Spawnable> getInventory() {
        return inventory;
    }
    public void collectPlastic(Plastic plastic) {
        if ((this.capacity + plastic.getAmount()) <= this.capacityMax){
            this.capacity += plastic.getAmount();
            inventory.add(plastic);
        }
        else System.out.println("Du har ikke kapacitet nok, bortskaf dit plast i havnen");
    }

    public void collectFish(DeadFish deadfish) {
        inventory.add(deadfish);
    }

    public int disposePlastic() {
        int amountOfPlastic = 0;
        for (Spawnable item : inventory) {
            if (item instanceof Plastic) {
                amountOfPlastic = amountOfPlastic + ((Plastic)item).getAmount();
            }
        }
        inventory.clear();
        return amountOfPlastic;
    }
}
