package pl.savemc.shop.gui.holders;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import pl.savemc.shop.gui.ItemRunnable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SMCInventoryHolder implements InventoryHolder {

    private Inventory inventory;
    private final Map<Integer, ItemRunnable> taskMap = Collections.synchronizedMap(new HashMap<>());

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addTask(Integer position, ItemRunnable itemRunnable) {
        taskMap.put(position, itemRunnable);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public void run(int index, Player player) {
        ItemRunnable itemRunnable = taskMap.get(index);

        if (itemRunnable == null) {
            return;
        }
        itemRunnable.run(player);
    }
}
