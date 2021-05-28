package pl.savemc.shop.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiData {
    private final String name;
    private final GuiExecutor guiExecutor;

    public GuiData(String name, GuiExecutor guiExecutor) {
        this.name = name;
        this.guiExecutor = guiExecutor;
    }

    public String getName() {
        return name;
    }

    public void run(InventoryClickEvent event){
        guiExecutor.execute(event);
    }
}
