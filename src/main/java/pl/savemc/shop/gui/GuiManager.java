package pl.savemc.shop.gui;

import java.util.ArrayList;

public class GuiManager {

    private ArrayList<GuiData> guiDataList = new ArrayList<>();

    public GuiManager() {
        add("ShopGui", new ShopGui());
    }

    private void add(String name, GuiExecutor guiExecutor){
        guiDataList.add(new GuiData(name, guiExecutor));
    }

}
