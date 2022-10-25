/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldOfZuul.textUI;

import worldOfZuul.*;

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
        System.out.println("Tak fordi du spillede med. Farvel.");
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

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Jeg ved ikke hvad du mener....");
                return false;
            case HELP:
                System.out.println("Du sejler forvirret rundt på verdenshavet.");
                System.out.println("Dine kommandoer er:");
                printHelp();
                break;
            case GO:
                if (game.goRoom(command)) {
                    game.newMove();
                    System.out.println(game.getRoomDescription());
                } else {
                    System.out.println("Der er land i sigte, du kan ikke sejle den vej!");
                }
                break;
            case QUIT:
                if (game.quit(command)) {
                    wantToQuit = true;
                } else {
                    System.out.println("Quit hvad?");
                }
                break;
            case DISPOSE:
                if (game.dispose(command)) {
                    System.out.println("Du har bortskaffet en masse plast");
                }
                else {
                    System.out.println("Du er ikke i havnen");
                }
                /*
            case COLLECT:
                if (game.collect(command)) {
                    System.out.println("Du har fjernet ");          // DET HER LORT ER HELLER IKKE FÆRDIG!!!!!!!!!!!!!!
                }
                */

            case INFO:
                if (game.info(command)) {
                    System.out.println(game.getDeathReason());
                }
                else {
                    System.out.println();
                }
        }

        return wantToQuit;


        }

    }

