package pl.savemc.shop.gui.layouts;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import pl.savemc.shop.utils.builders.GuiBuilder;
import pl.savemc.shop.gui.GuiID;
import pl.savemc.shop.gui.GuiManager;
import pl.savemc.shop.gui.holders.SMCInventoryHolder;
import pl.savemc.shop.utils.builders.ItemBuilder;

public class ShopMenuGuiLayout implements GuiLayout {
    private final GuiManager guiManager;

    public ShopMenuGuiLayout(GuiManager guiManager) {
        this.guiManager = guiManager;
    }

    @Override
    public Inventory createGui() {
        SMCInventoryHolder holder = new SMCInventoryHolder();
        GuiBuilder builder = new GuiBuilder(holder, 3, "§eSaveMC sklep");


        builder.fill(Material.BLACK_STAINED_GLASS_PANE, " ");

        builder.setItem(11,
                new ItemBuilder(Material.GOLDEN_CARROT).setName("&aTarg").build(),
                (player) -> player.openInventory(guiManager.getInventory(GuiID.TEST)));

        builder.setItem(Material.GOLDEN_CARROT, 11, 1, "&aTarg",
                (player) -> player.openInventory(guiManager.getInventory(GuiID.TEST)),
                "opis targu"); //TODO opis targu

        builder.setItem(Material.EMERALD, 13, 1, "&5Sklep",
                null,
                "opis sklepu"); //TODO opis sklepu
        builder.setItem(Material.BELL, 15, 1, "&eBank",
                null,
                "opis banku"); //TODO opis banku

        Inventory inventory = builder.getInventory();

        holder.setInventory(inventory);
        return inventory;
    }


}
