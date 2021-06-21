package pl.savemc.shop.gui;

import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.layouts.GuiLayout;
import pl.savemc.shop.gui.layouts.ShopMenuGuiLayout;
import pl.savemc.shop.gui.layouts.TestLayout;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {

    private final Map<GuiID, GuiLayout> guiMap = new HashMap<>();

    public GuiManager() {
        guiMap.put(GuiID.SHOP_MENU, new ShopMenuGuiLayout(this));
        guiMap.put(GuiID.TEST, new TestLayout());
    }

    public Inventory getInventory(GuiID id) {
        return guiMap.get(id).createGui();
    }
}
