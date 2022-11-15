package worldOfZuul;
import java.util.Random;

public class DeadFish implements Spawnable {
    private String deathReason;

    public DeadFish() {
        this.deathReason = "";
    }
    public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }
    @Override
    public boolean spawnChance(){
        Random random = new Random();
        int chance = random.nextInt(101);
        chance = chance +1;
        if(chance<50){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
        Random rng = new Random();
        int random = rng.nextInt(1, 7);

        switch (random) {
            case 1:
                setDeathReason("Fisken er viklet ind i en fiskesnor og er druknet");
                break;

            case 2:
                setDeathReason("Fisken har fået plastik i spiserøret og er død af sult");
                break;

            case 3:
                setDeathReason("Fisken er fanget i et uloveligt fiskenet");
                break;

            case 4:
                setDeathReason("Fisken har viklet sig ind i en plasitkpose og er druknet");
                break;

            case 5:
                setDeathReason("Fisken har troet plastik var mad og er død af sult");
                break;

            case 6:
                setDeathReason("Fisken har noget om kroppen og er blevet for tung til at følge med sin stime");
                break;
        }
    }
    @Override
    public String toString(){
        return "" +getDeathReason();
    }
}
