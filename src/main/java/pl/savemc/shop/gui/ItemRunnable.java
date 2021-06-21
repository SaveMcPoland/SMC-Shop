package pl.savemc.shop.gui;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface ItemRunnable {
    void run(Player player);
}
