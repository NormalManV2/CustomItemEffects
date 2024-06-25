package nuclearkat.customitemeffects.inventory;

import nuclearkat.customitemeffects.CustomItemEffects;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    private final CustomItemEffects customItemEffects;

    public InventoryManager(CustomItemEffects customItemEffects) {
        this.customItemEffects = customItemEffects;
    }

    private Inventory adminMenu(){
        Inventory adminMenu = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&cAdminMenu"));

        ItemStack blindingSword = customItemEffects.getCustomItem("BlindingSword");
        ItemStack widowsBlade = customItemEffects.getCustomItem("WidowsBlade");

        adminMenu.setItem(12, blindingSword);
        adminMenu.setItem(13, widowsBlade);

        return adminMenu;
    }

    public Inventory getAdminMenu(){return adminMenu();}

}
