package pl.savemc.shop.gui.clickExecutors;

import org.bukkit.event.inventory.InventoryClickEvent;

public class TestExecutor implements ClickExecutor {
    @Override
    public void execute(InventoryClickEvent event) {
        event.setCancelled(true);
    }
}
