package pl.savemc.shop.commands.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.savemc.shop.commands.CommandExecutor;
import pl.savemc.shop.gui.GuiBuilder;

public class ShopCommand implements CommandExecutor {

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player)){
            return;
        }

        GuiBuilder gui = new GuiBuilder(3, "Sklep");

        Player player = (Player) sender;

        gui.send(player);
    }

}
