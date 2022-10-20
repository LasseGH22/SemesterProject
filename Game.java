package worldOfZuul;

import java.util.List;

public class Game {

    private Room currentRoom;
    private CommandWords commands;

    public Game() {
        createRooms();
        commands = new CommandWordsImplementation();
    }

    private void createRooms() {
        Room A1, A2, A3, A4, A5;
        Room B1, B2, B3, B4, B5;
        Room C1, C2, C3, C4, C5;
        Room D1, D2, D3, D4, D5;
        Room E1, E2, E3, E4, E5;
        Room Harbour;

        A1 = new Room("You are on the ocean");
        A2 = new Room("You are on the ocean");
        A3 = new Room("You are on the ocean");
        A4 = new Room("You are on the ocean");
        A5 = new Room("You are on the ocean");
        B1 = new Room("You are on the ocean");
        B3 = new Room("You are on the ocean");
        B4 = new Room("You are on the ocean");
        B5 = new Room("You are on the ocean");
        C1 = new Room("You are on the ocean");
        C3 = new Room("You are on the ocean");
        D1 = new Room("You are on the ocean");
        D3 = new Room("You are on the ocean");
        D4 = new Room("You are on the ocean");
        D5 = new Room("You are on the ocean");
        E1 = new Room("You are on the ocean");
        E3 = new Room("You are on the ocean");
        E4 = new Room("You are on the ocean");
        E5 = new Room("You are on the ocean");

        B2 = new Room("You are stranded on an island");
        C2 = new Room("You are stranded on an island");
        C4 = new Room("You are stranded on an island");
        C5 = new Room("You are stranded on an island");
        D2 = new Room("You are stranded on an island");
        E2 = new Room("You are stranded on an island");

        Harbour = new Room("You are in the harbour");

        Room[] allOcean = {A1,A2,A3,A4,A5,B1,B3,B4,B5,C1,C3,D1,D3,D4,D5,E1,E3,E4,E5};
        Room[] allIslands = {B2,C2,C4,C5,D2,E2};

        Harbour.setExit("north",E3);

        A1.setExit("south",B1);
        A1.setExit("east",A2);

        A2.setExit("west",A1);
        A2.setExit("east",A3);

        A3.setExit("west",A2);
        A3.setExit("south",B3);
        A3.setExit("east",A4);

        A4.setExit("west",A3);
        A4.setExit("south",B4);
        A4.setExit("east",A5);

        A5.setExit("west",A4);
        A5.setExit("south",B5);

        B1.setExit("north",A1);
        B1.setExit("south",C1);

        B3.setExit("north",A3);
        B3.setExit("east",B4);
        B3.setExit("south",C3);



        currentRoom = Harbour;
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

}
