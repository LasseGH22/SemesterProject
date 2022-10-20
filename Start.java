package worldOfZuul;

import worldOfZuul.textUI.CommandLineClient;
import worldOfZuul.textUI.WorldOfZuulApplication;

public class Start {

    public static void main(String[] args){
        CommandLineClient client = new CommandLineClient();
        client.play();
        Game game = new Game();
        System.out.println(game.getRoomDescription());


    }
}