package pl.savemc.shop.gui.creators;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.gui.GuiBuilder;
import pl.savemc.shop.gui.GuiID;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;

public class ShopMenuGuiCreator implements GuiCreator {
    @Override
    public Inventory createGui() {
        SMCInventoryHolder holder = new SMCInventoryHolder(GuiID.SHOP_MENU);
        GuiBuilder builder = new GuiBuilder(holder, 1, "§eSaveMC sklep");

        builder.setItem(Material.GOLD_INGOT, 3, 1, "§eKup", "Kup se dirta byku", "Albo jakieś jajko se pierdolnij");
        builder.setItem(Material.IRON_INGOT, 5, 1, "§6Sprzedaj", "Sprzedaj złom byniu");

        Inventory inventory = builder.getInventory();
        holder.setInventory(inventory);
        return inventory;
    }
}
