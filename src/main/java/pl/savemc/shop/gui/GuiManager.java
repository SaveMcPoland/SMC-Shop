package pl.savemc.shop.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.clickExecutors.ShopMenuExecutor;
import pl.savemc.shop.gui.clickExecutors.TestExecutor;
import pl.savemc.shop.gui.creators.ShopMenuGuiCreator;
import pl.savemc.shop.gui.creators.TestCreator;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {

    private final Map<GuiID, GuiData> guiMap = new HashMap<>();

    public GuiManager() {
        guiMap.put(GuiID.SHOP_MENU, new GuiData(new ShopMenuGuiCreator(), new ShopMenuExecutor(this)));
        guiMap.put(GuiID.TEST, new GuiData(new TestCreator(), new TestExecutor()));
    }

    public void runClick(GuiID id, InventoryClickEvent event){
        guiMap.get(id).getExecutor().execute(event);
    }

    public Inventory getInventory(GuiID id) {
        return guiMap.get(id).getCreator().createGui();
    }

    @Deprecated
    public void openInventory(Player player, GuiID id) {
        player.openInventory(guiMap.get(id).getCreator().createGui());
    }
}
