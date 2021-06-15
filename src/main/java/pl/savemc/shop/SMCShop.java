package pl.savemc.shop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.savemc.shop.commands.CommandManager;
import pl.savemc.shop.commands.executors.ShopCommand;
import pl.savemc.shop.commands.executors.TestCommand;
import pl.savemc.shop.data.Config;
import pl.savemc.shop.data.ConfigManager;
import pl.savemc.shop.gui.GuiManager;
import pl.savemc.shop.listeners.InventoryClick;

public final class SMCShop extends JavaPlugin {

    private GuiManager guiManager;
    private CommandManager commandManager;
    private ConfigManager configManager;
    private Config config;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.config = configManager.getPluginConfig();
        this.guiManager = new GuiManager();

        this.commandManager = new CommandManager("smc-shop");
        this.commandManager.register(0, new ShopCommand(this), "shop", "sklep", "dajtamiderta");
        this.commandManager.register(1, new TestCommand(), "test");

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new InventoryClick(guiManager), this);
    }

    @Override
    public void onDisable() {
        this.configManager.saveConfig();
        commandManager.unregisterCommands();
    }

    public Config getPluginConfig() {
        return config;
    }

    public GuiManager getGuiManager() {
        return guiManager;
    }

}
