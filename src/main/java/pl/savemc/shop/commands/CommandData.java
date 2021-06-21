package pl.savemc.shop.commands;

import pl.savemc.shop.commands.executors.CommandExecutor;

import java.util.List;

public class CommandData {
  
    private final CommandExecutor commandExecutor;
    private final String name;
    private final List<String> aliases;

    public CommandData(CommandExecutor commandExecutor, String name, List<String> aliases) {
        this.commandExecutor = commandExecutor;
        this.name = name;
        this.aliases = aliases;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

}
