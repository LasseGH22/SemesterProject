/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfZuul.textUI;

import worldOfZuul.Command;
import worldOfZuul.Commands;
import worldOfZuul.Game;

/**
 *
 * @author ancla
 */
public class CommandLineClient {

    private Parser parser;
    private Game game;

    public CommandLineClient() {
        game = new Game();
        parser = new Parser(game);
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    public void pressEnterToContinue() {
        try {
            System.in.read();
        } catch(Exception e) { }
    }

    private void printWelcome() {
            System.out.println();
            System.out.println("Velkommen til Skipper Skrald!");
            System.out.println("Verdenshavenes sundhed og velvær er essentielt for at jorden er beboelig for mennesker og dyr.");
            System.out.println("Dog er vi mennesker ved at ødelægge det for os selv, grundet vores generelt dårlige håndtering af plastik.");
            System.out.println("Ifølge forskerne ender der årligt mere end 8 tons plastik i verdenshavene og det formodes at i 2050 vil der være mere plastik i havene end mængden af dyr");
            System.out.println("> Tryk enter");
            System.out.println();
            pressEnterToContinue();
            System.out.println("Du, Skipper Skrald skal hjælpe med at rede verdenshavene");
            System.out.println("Du skal sejle ud med dit skib, indsamle plast og herefter sejle tilbage til havnen og sende plasten til genbrug.");
            pressEnterToContinue();
            System.out.println("Held og lykke");
            System.out.println();
            try{ Thread.sleep(1000);}
            catch(Exception e) {System.out.println(e);}
            System.out.println("Skriv '" + Commands.HELP + "' hvis du har brug for hjælp");
            System.out.println();
            try{ Thread.sleep(1000);}
            catch(Exception e) {System.out.println(e);}
            System.out.println(game.getRoomDescription());
    }

    private void printHelp() {
        for(String str : game.getCommandDescriptions())
        {
            System.out.println(str + " ");
        }
    }

    //Controller
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        Commands commandWord = command.getCommandName();

        if (commandWord == Commands.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == Commands.HELP) {
            System.out.println("You are lost. You are alone. You wander");
            System.out.println("around at the university.");
            System.out.println();
            System.out.println("Your command words are:");
            printHelp();
        } else if (commandWord == Commands.GO) {
            if (game.goRoom(command)) {
                System.out.println(game.getRoomDescription());
            } else {
                System.out.println("Can't walk in that direction.");
            }
        } else if (commandWord == Commands.QUIT) {
            if (game.quit(command)) {
                wantToQuit = true;
            } else {
                System.out.println("Quit what?");
            }

        }
        return wantToQuit;
    }
}
