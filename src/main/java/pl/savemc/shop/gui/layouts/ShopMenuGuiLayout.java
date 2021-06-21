package pl.savemc.shop.gui.layouts;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.GuiBuilder;
import pl.savemc.shop.gui.GuiID;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;

public class ShopMenuGuiLayout implements GuiLayout {
    @Override
    public Inventory createGui() {
        SMCInventoryHolder holder = new SMCInventoryHolder(GuiID.SHOP_MENU);
        GuiBuilder builder = new GuiBuilder(holder, 3, "§eSaveMC sklep");

        builder.fill(Material.BLACK_STAINED_GLASS_PANE, " ");

        builder.setItem(Material.GOLDEN_CARROT, 11, 1, "&aTarg", "opis targu"); //TODO opis targu
        builder.setItem(Material.EMERALD, 13, 1, "&5Sklep", "opis sklepu"); //TODO opis sklepu
        builder.setItem(Material.BELL, 15, 1, "&eBank", "opis banku"); //TODO opis banku

        Inventory inventory = builder.getInventory();
        holder.setInventory(inventory);
        return inventory;
    }
}
