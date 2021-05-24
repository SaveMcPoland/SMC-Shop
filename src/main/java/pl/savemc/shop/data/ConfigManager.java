package pl.savemc.shop.data;

import net.dzikoysk.cdn.Cdn;
import net.dzikoysk.cdn.CdnFactory;
import org.panda_lang.utilities.commons.FileUtils;
import pl.savemc.shop.SMCShop;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class ConfigManager {

    private final Cdn cdn = CdnFactory.createYamlLike();
    private final File physicalFile;
    private final Logger logger;

    private Config pluginConfig;

    public ConfigManager(SMCShop plugin) {
        this.physicalFile = new File(plugin.getDataFolder(), "config.yml");
        this.logger = plugin.getLogger();

        try {
            if (physicalFile.exists()) {
                loadConfig();
                return;
            }

            if (physicalFile.getParentFile().mkdir()) {
                logger.info("Directory for the file has been created");
            }

            if (physicalFile.createNewFile()) {
                logger.info("File has been created :3");
            }

            loadConfig();
            saveConfig();
            logger.info("POLAND WITH CHICKEN SOUP");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadConfig() throws Exception {
        pluginConfig = cdn.load(physicalFile, Config.class);
    }

    public void saveConfig() {
        if (pluginConfig == null) {
            logger.severe("Cannot save or overwrite the contents of config.yml (Instance config is null)");
            return;
        }

        try {
            FileUtils.overrideFile(physicalFile, cdn.render(pluginConfig));
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Config getPluginConfig() {
        return pluginConfig;
    }
}
