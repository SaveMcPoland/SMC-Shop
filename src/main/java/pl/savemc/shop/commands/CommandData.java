package pl.savemc.shop.commands;

import java.util.List;

public class CommandData {

    private final int id;
    private final String name;
    private final CommandExecutor commandExecutor;
    private final List<String> alias;

    public CommandData(int id, String name, CommandExecutor commandExecutor, List<String> alias) {
        this.id = id;
        this.name = name;
        this.commandExecutor = commandExecutor;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public List<String> getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }
}
