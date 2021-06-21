package pl.savemc.shop.utils.builders;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import pl.savemc.shop.gui.ItemRunnable;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;

public class GuiBuilder implements InventoryHolder {

    private final SMCInventoryHolder holder;
    private final int size;
    private Inventory inventory;

    public GuiBuilder(SMCInventoryHolder holder, int rows, String title) {

        this.holder = holder;

        if (rows > 6){
            this.size = 54;
            return;
        }

        this.size = rows * 9;
        this.inventory = Bukkit.createInventory(holder, size, title);
    }

    public void setItem(int position, ItemStack item) {
        inventory.setItem(position, item);
    }

    public void setItem(int position, ItemStack item, ItemRunnable runnable) {
        inventory.setItem(position, item);
        holder.addTask(position, runnable);
    }

    public void fill(ItemBuilder builder) {
        ItemStack item = builder.build();

        for (int i = 0; i < size; i++) {
            inventory.setItem(i, item);
        }

    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

}
