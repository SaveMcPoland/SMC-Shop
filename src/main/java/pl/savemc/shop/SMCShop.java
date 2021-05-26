package pl.savemc.shop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.savemc.shop.commands.CommandManager;
import pl.savemc.shop.data.Config;
import pl.savemc.shop.data.ConfigManager;

public final class SMCShop extends JavaPlugin {

    private ConfigManager configManager;
    private Config config;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.config = configManager.getPluginConfig();
        this.commandManager = new CommandManager();
        this.commandManager.registerCommands();

        Bukkit.getLogger().info(config.startMessage);
    }

    @Override
    public void onDisable() {
        this.commandManager.unregisterCommands();
        this.configManager.saveConfig();
    }

    public Config getPluginConfig() {
        return config;
    }

}
