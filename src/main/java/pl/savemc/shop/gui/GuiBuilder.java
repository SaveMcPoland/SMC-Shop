package pl.savemc.shop.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiBuilder {

    private final int size;
    private final String name;
    private final Inventory inventory;

    public GuiBuilder(int columnQuantity, String name) {
        this.size = columnQuantity * 9;
        this.name = name;
        inventory = Bukkit.createInventory(null, columnQuantity, name);
    }

    public void setItem(int position, ItemStack itemStack) {
        inventory.setItem(position, itemStack);
    }

    public void fill(ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, itemStack);
        }
    }

    public void send(Player player){
        player.openInventory(inventory);
    }
}
