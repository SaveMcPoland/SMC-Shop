package pl.savemc.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import pl.savemc.shop.commands.command.ShopCommand;
import pl.savemc.shop.commands.command.TestCommand;

import java.util.*;

public class CommandManager {

    private final ArrayList<CommandData> commandDataList = new ArrayList<>();
    private final CommandMap commandMap = Bukkit.getCommandMap();
    private final Map<String, Command> knownCommands = commandMap.getKnownCommands();

    public CommandManager() {
        add(0, "sklep", new ShopCommand(), Arrays.asList("sklep", "kupsedirta"))                                                                                    ;
        add(1, "test",  new TestCommand(), Collections.emptyList());
    }

    public void registerCommands() {
        for (CommandData commandData : commandDataList) {
            String name = commandData.getName();
            CommandInstance commandInstance = new CommandInstance(commandData.getId(), name, commandData.getAliases(), this);

            if (knownCommands.containsKey(name)) {
                knownCommands.replace(name, commandInstance);
                continue;
            }

            commandMap.register(name, "smc-shop", commandInstance);
        }
    }

    public void unregisterCommands() {
        for (CommandData commandData : commandDataList) {
            knownCommands.remove(commandData.getName());

            List<String> aliases = commandData.getAliases();
            for (String alias : aliases) {
                knownCommands.remove(alias);
            }
        }
    }

    public void runCommand(int id, CommandSender sender, String label, String[] args) {
        for (CommandData commandData : commandDataList) {
            if (commandData.getId() != id) {
                continue;
            }

            commandData.getCommandExecutor().execute(sender, label, args);
        }
    }

    private void add(int id, String name, CommandExecutor commandExecutor, List<String> list) {
        commandDataList.add(new CommandData(id, name, commandExecutor, list));
    }

}

