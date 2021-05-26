package pl.savemc.shop.commands;

import java.util.List;

public class CommandData {

    private final int id;
    private final String name;
    private final CommandExecutor commandExecutor;
    private final List<String> aliases;

    public CommandData(int id, String name, CommandExecutor commandExecutor, List<String> aliases) {
        this.id = id;
        this.name = name;
        this.commandExecutor = commandExecutor;
        this.aliases = aliases;
    }

    public int getId() {
        return id;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getName() {
        return name;
    }
}
