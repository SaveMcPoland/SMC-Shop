package pl.savemc.shop.gui.clickExecutors;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pl.savemc.shop.gui.GuiID;
import pl.savemc.shop.gui.GuiManager;

public class ShopMenuExecutor implements ClickExecutor {

    private final GuiManager guiManager;

    public ShopMenuExecutor(GuiManager guiManager) {
        this.guiManager = guiManager;
    }

    @Override
    public void execute(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item == null){
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if (item.getType() == Material.GOLD_INGOT) {
            player.openInventory(guiManager.getInventory(GuiID.TEST));
        }
    }
}
