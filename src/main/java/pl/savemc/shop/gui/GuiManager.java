package pl.savemc.shop.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import pl.savemc.shop.gui.layouts.LayoutRunnable;
import pl.savemc.shop.gui.layouts.SMCLayout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GuiManager {

    private final Map<GuiID, LayoutRunnable> guiMap = new HashMap<>();
    private final GuiManager guiManager = this;

    public GuiManager() {

        guiMap.put(GuiID.SHOP_MENU,  () -> {
            SMCLayout shopMenu = new SMCLayout("&eSaveMC sklep", 3);

            shopMenu.fill(Material.BLACK_STAINED_GLASS_PANE, " ");

            shopMenu.setItem(11, Material.GOLDEN_CARROT, "&aTarg",    Collections.singletonList("Targ lore"));
            //() -> );
            shopMenu.setItem(13, Material.EMERALD,       "&5Sklep",   Collections.singletonList("Sklep lore"),
                    (player) -> player.openInventory(guiManager.getInventory(GuiID.SHOP)));
            shopMenu.setItem(15, Material.BELL,          "&eBank",    Collections.singletonList("Bank lore"));
            //() -> );

            return shopMenu.createGui();
        });

        guiMap.put(GuiID.SHOP, () -> {
                SMCLayout shop = new SMCLayout("&eSklep", 4);

                shop.fill(Material.BLACK_STAINED_GLASS_PANE, " ");

                shop.setItem(10, Material.IRON_PICKAXE,     "NAZWA");
                //() -> );
                shop.setItem(11, Material.WHEAT,            "NAZWA");
                //() -> );
                shop.setItem(12, Material.OAK_WOOD,         "NAZWA");
                //() -> );
                shop.setItem(13, Material.HONEYCOMB,        "NAZWA");
                //() -> );
                shop.setItem(14, Material.NAME_TAG,         "NAZWA");
                //() -> );
                shop.setItem(15, Material.ROSE_BUSH,        "NAZWA");
                //() -> );
                shop.setItem(16, Material.FISHING_ROD,      "NAZWA");
                //() -> );
                shop.setItem(19, Material.BOOK,             "NAZWA");
                //() -> );
                shop.setItem(20, Material.REDSTONE,         "NAZWA");
                //() -> );
                shop.setItem(21, Material.FIREWORK_ROCKET,  "NAZWA");
                //() -> );
                shop.setItem(22, Material.ZOMBIE_HEAD,      "NAZWA");
                //() -> );
                shop.setItem(23, Material.CROSSBOW,         "NAZWA");
                //() -> );
                shop.setItem(24, Material.STICK,            "NAZWA");
                //() -> );
                shop.setItem(25, Material.BARRIER,          "NAZWA",
                        (player) -> player.openInventory(this.getInventory(GuiID.SHOP_MENU)));

                return shop.createGui();
        });

    }

    public Inventory getInventory(GuiID id) {
        return guiMap.get(id).getInventory();
    }

}
