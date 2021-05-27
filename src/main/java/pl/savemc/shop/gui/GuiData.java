package pl.savemc.shop.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiData {
    private final String name;
    private final ClickExecutor clickExecutor;

    public GuiData(String name, ClickExecutor clickExecutor) {
        this.name = name;
        this.clickExecutor = clickExecutor;
    }

    public String getName() {
        return name;
    }

    public void run(InventoryClickEvent event){
        clickExecutor.execute(event);
    }
}
