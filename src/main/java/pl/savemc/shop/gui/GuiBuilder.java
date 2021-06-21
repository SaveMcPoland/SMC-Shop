package pl.savemc.shop.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import pl.savemc.shop.utils.ChatUtils;

import java.util.Arrays;

public class GuiBuilder implements InventoryHolder {

    private final InventoryHolder holder;
    private final int size;
    private Inventory inventory;

    public GuiBuilder(InventoryHolder holder, int rows, String title){

        this.holder = holder;

        if (rows > 6){
            this.size = 54;
            return;
        }
        this.size = rows * 9;
        inventory = Bukkit.createInventory(holder, size, title);
    }

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

    public void setItem(Material material, int position, int amount, String name, String... lore) {
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
    }

    public void setItem(Material material, int position, int amount) {
        if (position >= size) {
            position = size - 1;
        }

        ItemStack item = new ItemStack(material, amount);
        inventory.setItem(position, item);
    }


    public ItemStack getItemStack(int index) {
        return inventory.getItem(index);
    }

    public InventoryHolder getHolder() {
        return holder;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
