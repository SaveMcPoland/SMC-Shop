package pl.savemc.shop.gui.layouts;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.utils.builders.GuiBuilder;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;

public class TestLayout implements GuiLayout {
    @Override
    public Inventory createGui() {
        SMCInventoryHolder holder = new SMCInventoryHolder();
        GuiBuilder builder = new GuiBuilder(holder, 6, "SaveMC sklep - test");

        builder.setItem(Material.DIAMOND_BLOCK, 15, 32);
        builder.setItem(Material.DIAMOND_BLOCK, 20, 16);

        Inventory inventory = builder.getInventory();
        holder.setInventory(inventory);
        return inventory;
    }
}
