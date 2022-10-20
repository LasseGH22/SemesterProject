package worldOfZuul;
import java.util.Random;

public class DeadFish implements Spawnable {
    private String deathReason;

    public DeadFish(String deathReason) {
        this.deathReason = deathReason;
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
        int chance = random.nextInt(100);
        chance = chance +1;
        if(chance<26){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
        String reason1 = "Fisken er viklet ind i en fiskesnor og er druknet";
        String reason2 = "Fisken har fået plastik i spiserøret og er død af sult";
        String reason3 = "Fisken er fanget i et uloveligt fiskenet";
        String reason4 = "Fisken har viklet sig ind i en plasitkpose og er druknet";
        String reason5 = "Fisken har troet plastik var mad og er død af sult";
        String reason6 = "Fisken har noget om kroppen og er blevet for tung til at følge med sin stime";
        setDeathReason(reason1);
    }
}
