package pl.savemc.shop.gui.holders;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import pl.savemc.shop.gui.GuiID;

public class SMCInventoryHolder implements InventoryHolder {

    private Inventory inventory;
    private final GuiID id;

    public SMCInventoryHolder(GuiID id) {
        this.id = id;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public GuiID getId() {
        return id;
    }
}
