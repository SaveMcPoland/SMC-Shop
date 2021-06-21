package pl.savemc.shop.gui.layouts;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.ItemRunnable;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;
import pl.savemc.shop.utils.builders.GuiBuilder;
import pl.savemc.shop.utils.builders.ItemBuilder;

import java.util.List;

public class SMCLayout{

    private final GuiBuilder builder;
    private final SMCInventoryHolder holder;

    public SMCLayout(String name, int rows) {
        holder = new SMCInventoryHolder();
        builder = new GuiBuilder(holder, rows, name);
    }

    public void fill(Material material, String name) {
        builder.fill(new ItemBuilder(material).setName(name));
    }

    public void setItem(int position, Material material, String name) {
        builder.setItem(position, new ItemBuilder(material)
                .setName(name)
                .build());
    }

    public void setItem(int position, Material material, String name, List<String> lore) {
        builder.setItem(position, new ItemBuilder(material)
                .setName(name)
                .setLore(lore)
                .build());
    }

    public void setItem(int position, Material material, String name, ItemRunnable runnable) {
        builder.setItem(position, new ItemBuilder(material)
                        .setName(name)
                        .build(),
                        runnable);
    }

    public void setItem(int position, Material material, String name, List<String> lore, ItemRunnable runnable) {
        builder.setItem(position, new ItemBuilder(material)
                .setName(name)
                .setLore(lore)
                .build(),
                runnable);
    }

    public Inventory createGui() {
        Inventory inventory = builder.getInventory();
        holder.setInventory(inventory);
        return inventory;
    }
}
