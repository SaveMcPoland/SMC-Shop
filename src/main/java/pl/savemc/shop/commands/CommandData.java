package pl.savemc.shop.commands;

import pl.savemc.shop.commands.executors.CommandExecutor;

import java.util.List;

public class CommandData {
    private final CommandExecutor command;
    private final Integer id;
    private final String name;
    private final List<String> aliases;

    public CommandData(CommandExecutor command, Integer id, String name, List<String> aliases) {
        this.command = command;
        this.id = id;
        this.name = name;
        this.aliases = aliases;
    }

    public Integer getId() {
        return id;
    }

    public CommandExecutor getCommandExecutor() {
        return command;
    }

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

}
