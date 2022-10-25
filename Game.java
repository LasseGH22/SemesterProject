package worldOfZuul;

import java.util.List;
import java.util.Date;
import java.util.Calendar;

public class Game {

    private Room currentRoom;
    private CommandWords commands;

    private Date gameDate = new Date(122, Calendar.OCTOBER,0);

    public Game() {
        createRooms();
        commands = new CommandWordsImplementation();
    }
    //Creates the ship
    //Should be moved to constructor
    private Ship skipperSkrald = new Ship();
    private void createRooms() {
        Room A1, A2, A3, A4, A5;
        Room B1, B2, B3, B4, B5;
        Room C1, C2, C3, C4, C5;
        Room D1, D2, D3, D4, D5;
        Room E1, E2, E3, E4, E5;
        Room Harbor;

        A1 = new Room("ude på havet");
        A2 = new Room("ude på havet");
        A3 = new Room("ude på havet");
        A4 = new Room("ude på havet");
        A5 = new Room("ude på havet");
        B1 = new Room("ude på havet");
        B3 = new Room("ude på havet");
        B4 = new Room("ude på havet");
        B5 = new Room("ude på havet");
        C1 = new Room("ude på havet");
        C3 = new Room("ude på havet");
        D1 = new Room("ude på havet");
        D3 = new Room("ude på havet");
        D4 = new Room("ude på havet");
        D5 = new Room("ude på havet");
        E1 = new Room("ude på havet");
        E3 = new Room("ude på havet");
        E4 = new Room("ude på havet");
        E5 = new Room("ude på havet");

        B2 = new Room("strandet på en ø");
        C2 = new Room("strandet på en ø");
        C4 = new Room("strandet på en ø");
        C5 = new Room("strandet på en ø");
        D2 = new Room("strandet på en ø");
        E2 = new Room("strandet på en ø");

        //Changed Object type from Room to Harbor
        Harbor = new Harbor("nu i havnen");

        Room[] allOcean = {A1,A2,A3,A4,A5,B1,B3,B4,B5,C1,C3,D1,D3,D4,D5,E1,E3,E4,E5};
        Room[] allIslands = {B2,C2,C4,C5,D2,E2};

        Harbor.setExit("nord",E3);

        A1.setExit("syd",B1);
        A1.setExit("øst",A2);

        A2.setExit("vest",A1);
        A2.setExit("øst",A3);

        A3.setExit("vest",A2);
        A3.setExit("syd",B3);
        A3.setExit("øst",A4);

        A4.setExit("vest",A3);
        A4.setExit("syd",B4);
        A4.setExit("øst",A5);

        A5.setExit("vest",A4);
        A5.setExit("syd",B5);

        B1.setExit("nord",A1);
        B1.setExit("syd",C1);

        B3.setExit("nord",A3);
        B3.setExit("øst",B4);
        B3.setExit("syd",C3);

        B4.setExit("nord",A4);
        B4.setExit("vest",B3);
        B4.setExit("øst",B5);

        B5.setExit("nord",A5);
        B5.setExit("øst",B4);

        C1.setExit("nord",B1);
        C1.setExit("syd",D1);

        C3.setExit("nord",B3);
        C3.setExit("syd",D3);

        D1.setExit("nord",C1);
        D1.setExit("syd",E1);

        D3.setExit("nord",C3);
        D3.setExit("øst",D4);
        D3.setExit("syd",E3);

        D4.setExit("vest",D3);
        D4.setExit("syd",E4);
        D4.setExit("øst",D5);

        D5.setExit("vest",D4);
        D5.setExit("syd",E5);

        E1.setExit("nord",D1);

        E3.setExit("nord",D3);
        E3.setExit("syd",Harbor);
        E3.setExit("øst",E4);

        E4.setExit("vest",E3);
        E4.setExit("nord",D4);
        E4.setExit("øst",E5);

        E5.setExit("nord",D5);
        E5.setExit("vest",E4);


        currentRoom = Harbor;
    }

    public boolean goRoom(Command command) {

        if (!command.hasCommandValue()) {
            //No direction on command.
            //Can't continue with GO command.
            return false;
        }

        String direction = command.getCommandValue();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return false;
        } else {
            currentRoom = nextRoom;
            return true;
        }
    }

    public boolean quit(Command command) {
        if (command.hasCommandValue()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean dispose(Command command) {
        if (currentRoom.isHarbor()) {
            int score = skipperSkrald.disposePlastic();
            ((Harbor)currentRoom).setScore(score);
            return true;
        }
        return false;
    }

    public boolean info(Command command) {
        if (currentRoom.spawnDeadFish()) {
            return true;
        }
        return false;
    }

    public String getDeathReason() {
        return currentRoom.getDeathReason();
    }

    //TILFØJ METODE "COLLECT"

    public String getRoomDescription() {
        return currentRoom.getLongDescription();
    }

    public CommandWords getCommands() {
        return commands;
    }

    public List<String> getCommandDescriptions() {
        return commands.getCommandWords();
    }

    public Command getCommand(String word1, String word2) {
        return new CommandImplementation(commands.getCommand(word1), word2);
    }


    public boolean isIt2050() {
        if(gameDate.compareTo(new Date(150,0,0)) > 0) {
            return true;
        } else return false;
    }
    public Date getGameDate(){
        return gameDate;
    }
    public void newMove() {
        Calendar oneMonth = Calendar.getInstance();
        oneMonth.setTime(gameDate);
        oneMonth.add(Calendar.MONTH,+1);
        gameDate = oneMonth.getTime();

    }


}
