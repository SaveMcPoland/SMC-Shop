package pl.savemc.shop.gui;

import pl.savemc.shop.gui.clickExecutors.ClickExecutor;
import pl.savemc.shop.gui.creators.GuiCreator;

public class GuiData {
    private final GuiCreator creator;
    private final ClickExecutor executor;

    public GuiData(GuiCreator creator, ClickExecutor executor) {
        this.creator = creator;
        this.executor = executor;
    }

    public ClickExecutor getExecutor() {
        return executor;
    }

    public GuiCreator getCreator() {
        return creator;
    }
}
