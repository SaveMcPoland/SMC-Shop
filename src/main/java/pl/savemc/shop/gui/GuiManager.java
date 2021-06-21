package pl.savemc.shop.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.executors.ShopMenuExecutor;
import pl.savemc.shop.gui.executors.TestExecutor;
import pl.savemc.shop.gui.layouts.ShopMenuGuiLayout;
import pl.savemc.shop.gui.layouts.TestLayout;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {

    private final Map<GuiID, GuiData> guiMap = new HashMap<>();

    public GuiManager() {
        guiMap.put(GuiID.SHOP_MENU, new GuiData(new ShopMenuGuiLayout(), new ShopMenuExecutor(this)));
        guiMap.put(GuiID.TEST, new GuiData(new TestLayout(), new TestExecutor()));
    }

    public void runClick(GuiID id, InventoryClickEvent event){
        guiMap.get(id).getExecutor().execute(event);
    }

    public Inventory getInventory(GuiID id) {
        return guiMap.get(id).getLayout().createGui();
    }

    @Deprecated
    public void openInventory(Player player, GuiID id) {
        player.openInventory(guiMap.get(id).getLayout().createGui());
    }
}
