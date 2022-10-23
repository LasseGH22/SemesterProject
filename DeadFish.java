package worldOfZuul;
import java.util.Random;

public class DeadFish implements Spawnable {
    private String deathReason;
    int count;

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
        if(chance<102){
            return true;
        }
        else return false;
    }

    @Override
    public void spawn() {
        this.count++;
        if(this.count == 1){
            setDeathReason("Fisken er viklet ind i en fiskesnor og er druknet");}
        else if (this.count ==2) { setDeathReason("Fisken har fået plastik i spiserøret og er død af sult");}
        else if (this.count ==3) {setDeathReason("Fisken er fanget i et uloveligt fiskenet");}
        else if (this.count ==4) {setDeathReason("Fisken har viklet sig ind i en plasitkpose og er druknet");}
        else if (this.count ==5) {setDeathReason("Fisken har troet plastik var mad og er død af sult");}
        else if (this.count==6) {setDeathReason("Fisken har noget om kroppen og er blevet for tung til at følge med sin stime");
        this.count =0;}
    }
}
