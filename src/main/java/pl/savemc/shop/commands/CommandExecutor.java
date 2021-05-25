package pl.savemc.shop.commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutor {

    void execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings);

}
