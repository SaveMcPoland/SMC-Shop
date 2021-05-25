package pl.savemc.shop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import java.util.ArrayList;

public class CommandManager {

    private final ArrayList<CommandData> commandDataList = new ArrayList<>();
    private final CommandMap commandMap;

    public CommandManager() {
        commandMap = Bukkit.getServer().getCommandMap();
    }

    public void UnregisterCommands(){
    }
}

