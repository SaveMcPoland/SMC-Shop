package pl.savemc.shop.gui;

import pl.savemc.shop.gui.executors.ClickExecutor;
import pl.savemc.shop.gui.layouts.GuiLayout;

public class GuiData {
    private final GuiLayout layout;
    private final ClickExecutor executor;

    public GuiData(GuiLayout layout, ClickExecutor executor) {
        this.layout = layout;
        this.executor = executor;
    }

    public ClickExecutor getExecutor() {
        return executor;
    }

    public GuiLayout getLayout() {
        return layout;
    }
}
