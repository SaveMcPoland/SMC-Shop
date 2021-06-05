package pl.savemc.shop.commands.executors;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.savemc.shop.SMCShop;
import pl.savemc.shop.gui.GuiID;
import pl.savemc.shop.gui.GuiManager;

public class ShopCommand implements CommandExecutor{

    private final GuiManager guiManager;

    public ShopCommand(SMCShop plugin) {
        this.guiManager = plugin.getGuiManager();
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)){
            return;
        }

        Player player = (Player) sender;

        player.openInventory(guiManager.getInventory(GuiID.SHOP_MENU));
    }

}
