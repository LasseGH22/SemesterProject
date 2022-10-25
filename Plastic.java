package worldOfZuul;
import java.util.Random;

public class Plastic implements Spawnable{

    private double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
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

            double min =100;
            double max =1400;
            Random random = new Random();
            double amount = min + (max-min) * random.nextDouble();

            setAmount(amount);
    }
    @Override
    public String toString() {
        return amount + " tons plast";          // DENNE METODE ER IKKE FÆRDIG
    }
}

