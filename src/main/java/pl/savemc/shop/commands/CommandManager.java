package pl.savemc.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import pl.savemc.shop.commands.executors.CommandExecutor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {

    private final Map<Integer, CommandData> commandDataMap = new HashMap<>();
    private final CommandMap commandMap = Bukkit.getCommandMap();
    private final Map<String, Command> knownCommands = commandMap.getKnownCommands();
    private final String fallbackPrefix;

    public CommandManager(String fallbackPrefix) {
        this.fallbackPrefix = fallbackPrefix;
    }

    public void unregisterCommands() {
        for (CommandData commandData : commandDataMap.values()) {
            knownCommands.remove(commandData.getName());

            List<String> aliases = commandData.getAliases();

            for (String alias : aliases) {
                knownCommands.remove(alias);
            }
        }
    }

    public void runCommand(Integer id, CommandSender sender, String label, String[] args) {
        commandDataMap.get(id).getCommandExecutor().execute(sender, label, args);
    }

    public void register(Integer id, CommandExecutor executor, String name, String... aliasesTab) {
        List<String> aliases = Arrays.asList(aliasesTab);

        commandDataMap.put(id, new CommandData(executor, id, name, aliases));

        CommandInstance commandInstance = new CommandInstance(id, name, aliases, this);

        if (knownCommands.containsKey(name)) {
            knownCommands.remove(name);
            aliases.forEach(knownCommands::remove);
        }

        commandMap.register(name, fallbackPrefix, commandInstance);
    }

}