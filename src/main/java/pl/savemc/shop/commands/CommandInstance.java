package pl.savemc.shop.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandInstance extends BukkitCommand {

    private final Integer id;
    private final CommandManager commandManager;

    protected CommandInstance(Integer id, @NotNull String name, @NotNull List<String> aliases, CommandManager commandManager) {
        super(name, "", "/" + name, aliases);
        this.id = id;
        aliases.forEach(System.out::println);
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
        commandManager.runCommand(id, sender, label, args);
        return false;
    }
}
