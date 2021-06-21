package pl.savemc.shop.utils.builders;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.savemc.shop.utils.ChatUtils;

import java.util.List;
import java.util.Map;

public class ItemBuilder {

    private final ItemStack itemStack;

    private ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material, 1);
    }

    public ItemBuilder(Material material, byte data) {
        this.itemStack = new ItemStack(material, 1, data);
    }

    public static ItemBuilder of(ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    public ItemBuilder setType(Material type) {
        this.itemStack.setType(type);
        return this;
    }

    public ItemBuilder setData(byte data) {
        if (itemStack.getData() == null) {
            return this;
        }

        this.itemStack.getData().setData(data);
        return this;
    }

    public ItemBuilder setData(int data) {
        if (itemStack.getData() == null) {
            return this;
        }

        this.itemStack.getData().setData((byte) data);
        return this;
    }

    public ItemBuilder setName(String name) {
        ItemMeta meta = itemStack.getItemMeta();

        if (name != null) {
            meta.setDisplayName(ChatUtils.color(name));
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = itemStack.getItemMeta();

        meta.setLore(ChatUtils.color(lore));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        ItemMeta meta = itemStack.getItemMeta();

        if (enchantment != null) {
            meta.addEnchant(enchantment, lvl, true);
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setEnchantment(Enchantment enchantment, int lvl) {
        ItemMeta meta = itemStack.getItemMeta();

        if (enchantment != null) {
            this.removeEnchantments();
            meta.addEnchant(enchantment, lvl, true);
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        ItemMeta meta = itemStack.getItemMeta();

        if (enchantment != null) {
            meta.removeEnchant(enchantment);
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder removeEnchantments() {
        for (Map.Entry<Enchantment, Integer> enchantmentLvl : this.itemStack.getEnchantments().entrySet()) {
            this.removeEnchantment(enchantmentLvl.getKey());
        }

        return this;
    }

    public ItemBuilder setHideAttributes(boolean hide) {
        ItemMeta meta = itemStack.getItemMeta();

        if (hide) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        } else {
            meta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setItemFlag(ItemFlag itemFlag, boolean hide) {
        ItemMeta meta = itemStack.getItemMeta();

        if (hide) {
            meta.addItemFlags(itemFlag);
        } else {
            meta.removeItemFlags(itemFlag);
        }

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return new ItemStack(itemStack);
    }

    public static ItemStack newItem(Material material, byte data, int amount, String name, List<String> lore, Enchantment enchantment, int lvl) {

        ItemStack item = new ItemStack(material, amount, data);
        ItemMeta meta = item.getItemMeta();

        if (name != null) {
            meta.setDisplayName(name);
        }

        if (lore != null) {
            meta.setLore(lore);
        }

        if (enchantment != null) {
            meta.addEnchant(enchantment, lvl, true);
        }

        item.setItemMeta(meta);
        return item;
    }

    public int getAmount() {
        return itemStack.getAmount();
    }
}
