package worldOfZuul;

public enum Commands
{
    // LAV NY COMMAND; COLLECT
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), DISPOSE("dispose"), INFO("info");
    
    private String commandName;
    
    Commands(String commandString)
    {
        this.commandName = commandString;
    }
    
    public String toString()
    {
        return commandName;
    }
}
