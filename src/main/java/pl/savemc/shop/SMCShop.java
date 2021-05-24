package pl.savemc.shop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.savemc.shop.data.Config;
import pl.savemc.shop.data.ConfigManager;

import java.io.IOException;

public final class SMCShop extends JavaPlugin {

    private ConfigManager configManager;
    private Config config;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.config = configManager.getPluginConfig();

        Bukkit.getLogger().info(config.startMessage);
    }

    @Override
    public void onDisable() {
        this.configManager.saveConfig();
    }

    public Config getPluginConfig() {
        return config;
    }
}
