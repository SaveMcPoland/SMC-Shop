package pl.savemc.shop.commands.executors;

import org.bukkit.command.CommandSender;

public interface CommandExecutor {
    void execute(CommandSender sender, String label, String[] args);
}
