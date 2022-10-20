package worldOfZuul;
import java.util.Random;

public class Plastic implements Spawnable{

    private double amount;

    public Plastic() {
        this.amount = 100;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean spawnChance(){
        Random random = new Random();
        int chance = random.nextInt(100);
        chance = chance +1;
        if(chance<65){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
            int min =100;
            int max =1400;
            Random random = new Random();
            double amount = min + (max-min) * random.nextDouble();

            setAmount(amount);
    }
}

