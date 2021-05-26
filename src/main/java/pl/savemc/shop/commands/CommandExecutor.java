package pl.savemc.shop.commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutor {

    void execute(CommandSender sender, String label, String[] args);

}
