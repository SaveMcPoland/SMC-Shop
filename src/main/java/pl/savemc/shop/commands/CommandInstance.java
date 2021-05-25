package pl.savemc.shop.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

public class CommandInstance extends BukkitCommand {

    private final int id;

    protected CommandInstance(@NotNull String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        return false;
    }

    public int getId() {
        return id;
    }
}
