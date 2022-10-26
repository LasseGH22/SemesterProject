package worldOfZuul;
import java.util.Random;

public class Plastic implements Spawnable{

    private int amount;

    public Plastic (){
        this.amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean spawnChance(){
//      Boolean der giver en 64% chance for at give true
        Random random = new Random();
        int chance = random.nextInt(101);
        if(chance<65){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
//      Laver tilfældigt mængde plast nellen 100 og 1400
        int min = 100;
        int max = 1400;
        int amount = (int) (Math.random() * ((max - min) + 1)) + min;

        setAmount(amount);
    }

}

