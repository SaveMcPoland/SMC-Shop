package pl.savemc.shop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        InventoryHolder standardHolder = inventory.getHolder();

        if (!(standardHolder instanceof SMCInventoryHolder)) {
            return;
        }

        event.setCancelled(true);

        SMCInventoryHolder holder = (SMCInventoryHolder) standardHolder;

        holder.run(event.getSlot(), (Player) event.getWhoClicked());
    }

}