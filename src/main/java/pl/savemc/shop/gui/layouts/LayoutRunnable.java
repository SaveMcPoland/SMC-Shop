package pl.savemc.shop.gui.layouts;

import org.bukkit.inventory.Inventory;

@FunctionalInterface
public interface LayoutRunnable {
    Inventory getInventory();
}
