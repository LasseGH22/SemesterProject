package worldOfZuul;

public enum Commands
{
    GO("sejl"), QUIT("quit"), HELP("hjælp"), UNKNOWN("?"),
    DISPOSE("bortskaf"), COLLECT("indsaml"), INFO("info");

    
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
