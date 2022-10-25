package worldOfZuul;
import java.util.Random;

public class Plastic implements Spawnable{

    private int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean spawnChance(){
        Random random = new Random();
        int chance = random.nextInt(101);
        if(chance<65){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
        int min = 100;
        int max = 1400;
        int amount = (int) (Math.random() * ((max - min) + 1)) + min;

        setAmount(amount);
    }

}

