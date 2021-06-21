package pl.savemc.shop.utils.builders;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import pl.savemc.shop.gui.ItemRunnable;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;
import pl.savemc.shop.utils.ChatUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        inventory = Bukkit.createInventory(holder, size, title);
    }

    public void setItem(int position, ItemStack item) {
        inventory.setItem(position, item);
    }

    public void setItem(int position, ItemStack item, ItemRunnable runnable) {
        inventory.setItem(position, item);
        holder.addTask(position, runnable);
    }

    public void fill(ItemBuilder builder) {



    }

    @Deprecated
    public void fill(Material material, String name) {

        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (name != null) {
            meta.setDisplayName(ChatUtils.color(name));
        }

        for (int i = 0; i < size; i++) {
            inventory.setItem(i, item);
        }

    }

    @Deprecated
    public void setItem(Material material, int position, int amount, String name, ItemRunnable itemRunnable, String... lore) {
        if (position >= size) {
            position = size - 1;
        }

        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if (name != null) {
            meta.setDisplayName(ChatUtils.color(name));
        }

        if (lore != null && lore.length != 0) {
            meta.setLore(ChatUtils.color(Arrays.asList(lore)));
        }

        item.setItemMeta(meta);
        inventory.setItem(position, item);

        holder.addTask(position, itemRunnable);
    }

    @Deprecated
    public void setItem(Material material, int position, int amount) {
        if (position >= size) {
            position = size - 1;
        }

        ItemStack item = new ItemStack(material, amount);
        inventory.setItem(position, item);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

}
